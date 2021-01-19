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
    private static int kwW = 1500;
    private static int kwX = 500;

    public static void cTP() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cTB().cTC();
            String cTR = cTR();
            if (!TextUtils.isEmpty(cTR)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Me(cTR), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cTB().cTD();
        }
    }

    public static void CC(int i) {
        if (i < kwX) {
            i = kwX;
        }
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cTQ() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kwW);
    }

    private static String cTR() {
        List<String> cTS;
        StringBuilder sb = new StringBuilder();
        try {
            cTS = cTS();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cTS == null || cTS.size() == 0) {
            return null;
        }
        int cTQ = cTQ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cTS.size() + " max is " + cTQ, new Object[0]);
        if (cTS.size() > cTQ) {
            boolean z = true;
            for (String str : cTS.subList(0, 2000 >= cTS.size() - cTQ ? cTS.size() - cTQ : 2000)) {
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

    public static List<String> cTS() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cTB().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Me(String str) {
        try {
            return h.cTB().Mc("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
