package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static int exd = TbConfig.POST_IMAGE_SMALL;
    private static int exe = 500;

    public static void aGN() {
        if (!ap.nu()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.aGB().aGC();
            String aGP = aGP();
            if (!TextUtils.isEmpty(aGP)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mY(aGP), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.aGB().endTransaction();
        }
    }

    public static void pU(int i) {
        if (i < exe) {
            i = exe;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aGO() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", exd);
    }

    private static String aGP() {
        List<String> aGQ;
        StringBuilder sb = new StringBuilder();
        try {
            aGQ = aGQ();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aGQ == null || aGQ.size() == 0) {
            return null;
        }
        int aGO = aGO();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aGQ.size() + " max is " + aGO, new Object[0]);
        if (aGQ.size() > aGO) {
            boolean z = true;
            for (String str : aGQ.subList(0, 2000 >= aGQ.size() - aGO ? aGQ.size() - aGO : 2000)) {
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

    private static List<String> aGQ() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.aGB().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            n.i(cursor);
        }
        return arrayList;
    }

    private static boolean mY(String str) {
        try {
            return g.aGB().mX("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
