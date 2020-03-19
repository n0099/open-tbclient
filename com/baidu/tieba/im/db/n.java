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
    private static int hzW = 1500;
    private static int hzX = 500;

    public static void bUY() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bUL().bUM();
            String bVa = bVa();
            if (!TextUtils.isEmpty(bVa)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Da(bVa), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bUL().bUN();
        }
    }

    public static void wv(int i) {
        if (i < hzX) {
            i = hzX;
        }
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int bUZ() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_MAX_STRANGER, hzW);
    }

    private static String bVa() {
        List<String> bVb;
        StringBuilder sb = new StringBuilder();
        try {
            bVb = bVb();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bVb == null || bVb.size() == 0) {
            return null;
        }
        int bUZ = bUZ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bVb.size() + " max is " + bUZ, new Object[0]);
        if (bVb.size() > bUZ) {
            boolean z = true;
            for (String str : bVb.subList(0, 2000 >= bVb.size() - bUZ ? bVb.size() - bUZ : 2000)) {
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

    public static List<String> bVb() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bUL().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Da(String str) {
        try {
            return h.bUL().CY("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
