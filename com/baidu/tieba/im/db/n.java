package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int iQq = 1500;
    private static int iQr = 500;

    public static void cpU() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cpH().cpI();
            String cpW = cpW();
            if (!TextUtils.isEmpty(cpW)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + GW(cpW), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cpH().cpJ();
        }
    }

    public static void yl(int i) {
        if (i < iQr) {
            i = iQr;
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cpV() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_MAX_STRANGER, iQq);
    }

    private static String cpW() {
        List<String> cpX;
        StringBuilder sb = new StringBuilder();
        try {
            cpX = cpX();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cpX == null || cpX.size() == 0) {
            return null;
        }
        int cpV = cpV();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cpX.size() + " max is " + cpV, new Object[0]);
        if (cpX.size() > cpV) {
            boolean z = true;
            for (String str : cpX.subList(0, 2000 >= cpX.size() - cpV ? cpX.size() - cpV : 2000)) {
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

    public static List<String> cpX() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cpH().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean GW(String str) {
        try {
            return h.cpH().GU("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
