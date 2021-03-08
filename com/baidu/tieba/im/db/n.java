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
    private static int kHs = 1500;
    private static int kHt = 500;

    public static void cWb() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cVN().cVO();
            String cWd = cWd();
            if (!TextUtils.isEmpty(cWd)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + MZ(cWd), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVN().cVP();
        }
    }

    public static void CX(int i) {
        if (i < kHt) {
            i = kHt;
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cWc() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kHs);
    }

    private static String cWd() {
        List<String> cWe;
        StringBuilder sb = new StringBuilder();
        try {
            cWe = cWe();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cWe == null || cWe.size() == 0) {
            return null;
        }
        int cWc = cWc();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cWe.size() + " max is " + cWc, new Object[0]);
        if (cWe.size() > cWc) {
            boolean z = true;
            for (String str : cWe.subList(0, 2000 >= cWe.size() - cWc ? cWe.size() - cWc : 2000)) {
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

    public static List<String> cWe() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cVN().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean MZ(String str) {
        try {
            return h.cVN().MX("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
