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
    private static int ijQ = 1500;
    private static int ijR = 500;

    public static void cfy() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cfl().cfm();
            String cfA = cfA();
            if (!TextUtils.isEmpty(cfA)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + EL(cfA), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cfl().cfn();
        }
    }

    public static void wT(int i) {
        if (i < ijR) {
            i = ijR;
        }
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cfz() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_MAX_STRANGER, ijQ);
    }

    private static String cfA() {
        List<String> cfB;
        StringBuilder sb = new StringBuilder();
        try {
            cfB = cfB();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cfB == null || cfB.size() == 0) {
            return null;
        }
        int cfz = cfz();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cfB.size() + " max is " + cfz, new Object[0]);
        if (cfB.size() > cfz) {
            boolean z = true;
            for (String str : cfB.subList(0, 2000 >= cfB.size() - cfz ? cfB.size() - cfz : 2000)) {
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

    public static List<String> cfB() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cfl().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean EL(String str) {
        try {
            return h.cfl().EJ("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
