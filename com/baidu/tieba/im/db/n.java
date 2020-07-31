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
    private static int iXt = 1500;
    private static int iXu = 500;

    public static void ctA() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.ctm().ctn();
            String ctC = ctC();
            if (!TextUtils.isEmpty(ctC)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + HK(ctC), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.ctm().cto();
        }
    }

    public static void yG(int i) {
        if (i < iXu) {
            i = iXu;
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int ctB() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_MAX_STRANGER, iXt);
    }

    private static String ctC() {
        List<String> ctD;
        StringBuilder sb = new StringBuilder();
        try {
            ctD = ctD();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (ctD == null || ctD.size() == 0) {
            return null;
        }
        int ctB = ctB();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + ctD.size() + " max is " + ctB, new Object[0]);
        if (ctD.size() > ctB) {
            boolean z = true;
            for (String str : ctD.subList(0, 2000 >= ctD.size() - ctB ? ctD.size() - ctB : 2000)) {
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

    public static List<String> ctD() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.ctm().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean HK(String str) {
        try {
            return h.ctm().HI("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
