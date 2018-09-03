package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.p.av;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int eqC = TbConfig.POST_IMAGE_SMALL;
    private static int eqD = 500;

    public static void aJP() {
        if (!av.iq()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.aJD().aJE();
            String aJR = aJR();
            if (!TextUtils.isEmpty(aJR)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + oq(aJR), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJD().endTransaction();
        }
    }

    public static void nZ(int i) {
        if (i < eqD) {
            i = eqD;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aJQ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", eqC);
    }

    private static String aJR() {
        List<String> aJS;
        StringBuilder sb = new StringBuilder();
        try {
            aJS = aJS();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aJS == null || aJS.size() == 0) {
            return null;
        }
        int aJQ = aJQ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aJS.size() + " max is " + aJQ, new Object[0]);
        if (aJS.size() > aJQ) {
            boolean z = true;
            for (String str : aJS.subList(0, 2000 >= aJS.size() - aJQ ? aJS.size() - aJQ : 2000)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static List<String> aJS() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.aJD().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.e(cursor);
        }
        return arrayList;
    }

    public static boolean oq(String str) {
        try {
            return h.aJD().op("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
