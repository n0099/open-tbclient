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
    private static int izl = 1500;
    private static int izm = 500;

    public static void cme() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.clR().clS();
            String cmg = cmg();
            if (!TextUtils.isEmpty(cmg)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + Gu(cmg), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.clR().clT();
        }
    }

    public static void xB(int i) {
        if (i < izm) {
            i = izm;
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cmf() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_MAX_STRANGER, izl);
    }

    private static String cmg() {
        List<String> cmh;
        StringBuilder sb = new StringBuilder();
        try {
            cmh = cmh();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cmh == null || cmh.size() == 0) {
            return null;
        }
        int cmf = cmf();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cmh.size() + " max is " + cmf, new Object[0]);
        if (cmh.size() > cmf) {
            boolean z = true;
            for (String str : cmh.subList(0, 2000 >= cmh.size() - cmf ? cmh.size() - cmf : 2000)) {
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

    public static List<String> cmh() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.clR().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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
            return h.clR().Gs("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
