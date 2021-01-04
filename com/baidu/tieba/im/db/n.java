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
    private static int kBB = 1500;
    private static int kBC = 500;

    public static void cXG() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cXs().cXt();
            String cXI = cXI();
            if (!TextUtils.isEmpty(cXI)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Nm(cXI), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cXs().cXu();
        }
    }

    public static void Ej(int i) {
        if (i < kBC) {
            i = kBC;
        }
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cXH() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kBB);
    }

    private static String cXI() {
        List<String> cXJ;
        StringBuilder sb = new StringBuilder();
        try {
            cXJ = cXJ();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cXJ == null || cXJ.size() == 0) {
            return null;
        }
        int cXH = cXH();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cXJ.size() + " max is " + cXH, new Object[0]);
        if (cXJ.size() > cXH) {
            boolean z = true;
            for (String str : cXJ.subList(0, 2000 >= cXJ.size() - cXH ? cXJ.size() - cXH : 2000)) {
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

    public static List<String> cXJ() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cXs().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Nm(String str) {
        try {
            return h.cXs().Nk("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
