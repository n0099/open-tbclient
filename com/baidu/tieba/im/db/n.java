package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.au;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int eiU = TbConfig.POST_IMAGE_SMALL;
    private static int eiV = 500;

    public static void aIk() {
        if (!au.ip()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.aHY().aHZ();
            String aIm = aIm();
            if (!TextUtils.isEmpty(aIm)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + ok(aIm), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aHY().endTransaction();
        }
    }

    public static void nE(int i) {
        if (i < eiV) {
            i = eiV;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aIl() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", eiU);
    }

    private static String aIm() {
        List<String> aIn;
        StringBuilder sb = new StringBuilder();
        try {
            aIn = aIn();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aIn == null || aIn.size() == 0) {
            return null;
        }
        int aIl = aIl();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aIn.size() + " max is " + aIl, new Object[0]);
        if (aIn.size() > aIl) {
            boolean z = true;
            for (String str : aIn.subList(0, 2000 >= aIn.size() - aIl ? aIn.size() - aIl : 2000)) {
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

    public static List<String> aIn() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.aHY().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean ok(String str) {
        try {
            return h.aHY().oj("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
