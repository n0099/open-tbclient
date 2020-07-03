package com.baidu.tieba.im.db;

import android.database.Cursor;
import com.baidu.android.util.media.annotations.MediaQueryParam;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static String iPQ = "tb_oficial_msg_";
    private static a iQo;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l cpQ() {
        l lVar;
        synchronized (l.class) {
            if (iQo == null) {
                iQo = new l();
            }
            lVar = (l) iQo;
        }
        return lVar;
    }

    public static List<String> cpR() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cpG().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time" + MediaQueryParam.SORT_ASC, new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.close(cursor);
        }
        return arrayList;
    }
}
