package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n {
    private static int jmu = 1500;
    private static int jmv = 500;

    public static void cEr() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cEd().cEe();
            String cEt = cEt();
            if (!TextUtils.isEmpty(cEt)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + KC(cEt), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cEd().cEf();
        }
    }

    public static void AZ(int i) {
        if (i < jmv) {
            i = jmv;
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cEs() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_MAX_STRANGER, jmu);
    }

    private static String cEt() {
        List<String> cEu;
        StringBuilder sb = new StringBuilder();
        try {
            cEu = cEu();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cEu == null || cEu.size() == 0) {
            return null;
        }
        int cEs = cEs();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cEu.size() + " max is " + cEs, new Object[0]);
        if (cEu.size() > cEs) {
            boolean z = true;
            for (String str : cEu.subList(0, 2000 >= cEu.size() - cEs ? cEu.size() - cEs : 2000)) {
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

    public static List<String> cEu() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cEd().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean KC(String str) {
        try {
            return h.cEd().KA("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
