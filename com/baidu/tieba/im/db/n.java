package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.p.az;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int eHb = TbConfig.POST_IMAGE_SMALL;
    private static int eHc = 500;

    public static void aOQ() {
        if (!az.jJ()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.aOE().aOF();
            String aOS = aOS();
            if (!TextUtils.isEmpty(aOS)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + py(aOS), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aOE().endTransaction();
        }
    }

    public static void pu(int i) {
        if (i < eHc) {
            i = eHc;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aOR() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", eHb);
    }

    private static String aOS() {
        List<String> aOT;
        StringBuilder sb = new StringBuilder();
        try {
            aOT = aOT();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aOT == null || aOT.size() == 0) {
            return null;
        }
        int aOR = aOR();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aOT.size() + " max is " + aOR, new Object[0]);
        if (aOT.size() > aOR) {
            boolean z = true;
            for (String str : aOT.subList(0, 2000 >= aOT.size() - aOR ? aOT.size() - aOR : 2000)) {
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

    public static List<String> aOT() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.aOE().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean py(String str) {
        try {
            return h.aOE().px("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
