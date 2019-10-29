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
    private static int gFu = 1500;
    private static int gFv = 500;

    public static void bAG() {
        if (!bh.isOn()) {
            com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bAs().bAt();
            String bAI = bAI();
            if (!TextUtils.isEmpty(bAI)) {
                com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + xQ(bAI), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAs().bAu();
        }
    }

    public static void ub(int i) {
        if (i < gFv) {
            i = gFv;
        }
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int bAH() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_MAX_STRANGER, gFu);
    }

    private static String bAI() {
        List<String> bAJ;
        StringBuilder sb = new StringBuilder();
        try {
            bAJ = bAJ();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bAJ == null || bAJ.size() == 0) {
            return null;
        }
        int bAH = bAH();
        com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bAJ.size() + " max is " + bAH, new Object[0]);
        if (bAJ.size() > bAH) {
            boolean z = true;
            for (String str : bAJ.subList(0, 2000 >= bAJ.size() - bAH ? bAJ.size() - bAH : 2000)) {
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

    public static List<String> bAJ() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bAs().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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
            return h.bAs().xO("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
