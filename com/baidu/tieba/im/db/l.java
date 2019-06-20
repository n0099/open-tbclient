package com.baidu.tieba.im.db;

import android.database.Cursor;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static String gyb = "tb_oficial_msg_";
    private static a gyz;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l bAk() {
        l lVar;
        synchronized (l.class) {
            if (gyz == null) {
                gyz = new l();
            }
            lVar = (l) gyz;
        }
        return lVar;
    }

    public static List<String> bAl() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bAb().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.e(cursor);
        }
        return arrayList;
    }
}
