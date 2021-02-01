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
    private static int kFc = 1500;
    private static int kFd = 500;

    public static void cVN() {
        if (!StrangeCleanSwitch.isOn()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.cVz().cVA();
            String cVP = cVP();
            if (!TextUtils.isEmpty(cVP)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + MS(cVP), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVz().cVB();
        }
    }

    public static void CU(int i) {
        if (i < kFd) {
            i = kFd;
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_MAX_STRANGER, i);
    }

    private static int cVO() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_MAX_STRANGER, kFc);
    }

    private static String cVP() {
        List<String> cVQ;
        StringBuilder sb = new StringBuilder();
        try {
            cVQ = cVQ();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (cVQ == null || cVQ.size() == 0) {
            return null;
        }
        int cVO = cVO();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + cVQ.size() + " max is " + cVO, new Object[0]);
        if (cVQ.size() > cVO) {
            boolean z = true;
            for (String str : cVQ.subList(0, 2000 >= cVQ.size() - cVO ? cVQ.size() - cVO : 2000)) {
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

    public static List<String> cVQ() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cVz().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean MS(String str) {
        try {
            return h.cVz().MQ("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
