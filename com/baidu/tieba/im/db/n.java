package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int kqK = 1500;
    private static int kqL = 500;

    public static void cWj() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cVV().cVW();
            String cWl = cWl();
            if (!TextUtils.isEmpty(cWl)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Ns(cWl), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVV().cVX();
        }
    }

    public static void DZ(int i) {
        if (i < kqL) {
            i = kqL;
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cWk() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kqK);
    }

    private static String cWl() {
        List<String> cWm;
        StringBuilder sb = new StringBuilder();
        try {
            cWm = cWm();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cWm == null || cWm.size() == 0) {
            return null;
        }
        int cWk = cWk();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cWm.size() + " max is " + cWk, new Object[0]);
        if (cWm.size() > cWk) {
            boolean z = true;
            for (String str : cWm.subList(0, 2000 >= cWm.size() - cWk ? cWm.size() - cWk : 2000)) {
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

    public static List<String> cWm() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cVV().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Ns(String str) {
        try {
            return h.cVV().Nq("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
