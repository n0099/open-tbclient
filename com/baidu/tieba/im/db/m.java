package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.an;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static int dIs = TbConfig.POST_IMAGE_SMALL;
    private static int dIt = 500;

    public static void azy() {
        if (!an.fS()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.azm().azn();
            String azA = azA();
            if (!TextUtils.isEmpty(azA)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mM(azA), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.azm().endTransaction();
        }
    }

    public static void nc(int i) {
        if (i < dIt) {
            i = dIt;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int azz() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", dIs);
    }

    private static String azA() {
        List<String> azB;
        StringBuilder sb = new StringBuilder();
        try {
            azB = azB();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (azB == null || azB.size() == 0) {
            return null;
        }
        int azz = azz();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + azB.size() + " max is " + azz, new Object[0]);
        if (azB.size() > azz) {
            boolean z = true;
            for (String str : azB.subList(0, 2000 >= azB.size() - azz ? azB.size() - azz : 2000)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static List<String> azB() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.azm().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            n.e(cursor);
        }
        return arrayList;
    }

    private static boolean mM(String str) {
        try {
            return g.azm().mL("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
