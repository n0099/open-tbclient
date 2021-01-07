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

    public static void cXH() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cXt().cXu();
            String cXJ = cXJ();
            if (!TextUtils.isEmpty(cXJ)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Nl(cXJ), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cXt().cXv();
        }
    }

    public static void Ej(int i) {
        if (i < kBC) {
            i = kBC;
        }
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cXI() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kBB);
    }

    private static String cXJ() {
        List<String> cXK;
        StringBuilder sb = new StringBuilder();
        try {
            cXK = cXK();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cXK == null || cXK.size() == 0) {
            return null;
        }
        int cXI = cXI();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cXK.size() + " max is " + cXI, new Object[0]);
        if (cXK.size() > cXI) {
            boolean z = true;
            for (String str : cXK.subList(0, 2000 >= cXK.size() - cXI ? cXK.size() - cXI : 2000)) {
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

    public static List<String> cXK() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cXt().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean Nl(String str) {
        try {
            return h.cXt().Nj("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
