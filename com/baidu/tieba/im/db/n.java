package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.t.bh;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int gED = 1500;
    private static int gEE = 500;

    public static void bAE() {
        if (!bh.isOn()) {
            com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bAq().bAr();
            String bAG = bAG();
            if (!TextUtils.isEmpty(bAG)) {
                com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + xQ(bAG), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAq().bAs();
        }
    }

    public static void ua(int i) {
        if (i < gEE) {
            i = gEE;
        }
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int bAF() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_MAX_STRANGER, gED);
    }

    private static String bAG() {
        List<String> bAH;
        StringBuilder sb = new StringBuilder();
        try {
            bAH = bAH();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bAH == null || bAH.size() == 0) {
            return null;
        }
        int bAF = bAF();
        com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bAH.size() + " max is " + bAF, new Object[0]);
        if (bAH.size() > bAF) {
            boolean z = true;
            for (String str : bAH.subList(0, 2000 >= bAH.size() - bAF ? bAH.size() - bAF : 2000)) {
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

    public static List<String> bAH() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bAq().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.close(cursor);
        }
        return arrayList;
    }

    public static boolean xQ(String str) {
        try {
            return h.bAq().xO("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
