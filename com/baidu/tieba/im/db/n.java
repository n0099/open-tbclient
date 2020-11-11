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
    private static int kcw = 1500;
    private static int kcx = 500;

    public static void cRp() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cRb().cRc();
            String cRr = cRr();
            if (!TextUtils.isEmpty(cRr)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + MJ(cRr), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cRb().cRd();
        }
    }

    public static void CM(int i) {
        if (i < kcx) {
            i = kcx;
        }
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cRq() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kcw);
    }

    private static String cRr() {
        List<String> cRs;
        StringBuilder sb = new StringBuilder();
        try {
            cRs = cRs();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cRs == null || cRs.size() == 0) {
            return null;
        }
        int cRq = cRq();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cRs.size() + " max is " + cRq, new Object[0]);
        if (cRs.size() > cRq) {
            boolean z = true;
            for (String str : cRs.subList(0, 2000 >= cRs.size() - cRq ? cRs.size() - cRq : 2000)) {
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

    public static List<String> cRs() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cRb().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean MJ(String str) {
        try {
            return h.cRb().MH("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
