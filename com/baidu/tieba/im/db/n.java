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
    private static int iyy = 1500;
    private static int iyz = 500;

    public static void clV() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.clI().clJ();
            String clX = clX();
            if (!TextUtils.isEmpty(clX)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Gu(clX), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.clI().clK();
        }
    }

    public static void xz(int i) {
        if (i < iyz) {
            i = iyz;
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int clW() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_MAX_STRANGER, iyy);
    }

    private static String clX() {
        List<String> clY;
        StringBuilder sb = new StringBuilder();
        try {
            clY = clY();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (clY == null || clY.size() == 0) {
            return null;
        }
        int clW = clW();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + clY.size() + " max is " + clW, new Object[0]);
        if (clY.size() > clW) {
            boolean z = true;
            for (String str : clY.subList(0, 2000 >= clY.size() - clW ? clY.size() - clW : 2000)) {
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

    public static List<String> clY() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.clI().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Gu(String str) {
        try {
            return h.clI().Gs("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
