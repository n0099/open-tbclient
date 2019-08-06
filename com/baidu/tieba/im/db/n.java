package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.t.bh;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int gFE = TbConfig.POST_IMAGE_SMALL;
    private static int gFF = 500;

    public static void bDh() {
        if (!bh.iN()) {
            com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bCU().bCV();
            String bDj = bDj();
            if (!TextUtils.isEmpty(bDj)) {
                com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + yZ(bDj), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCU().bCW();
        }
    }

    public static void vs(int i) {
        if (i < gFF) {
            i = gFF;
        }
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_max_stranger", i);
    }

    private static int bDi() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_max_stranger", gFE);
    }

    private static String bDj() {
        List<String> bDk;
        StringBuilder sb = new StringBuilder();
        try {
            bDk = bDk();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bDk == null || bDk.size() == 0) {
            return null;
        }
        int bDi = bDi();
        com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bDk.size() + " max is " + bDi, new Object[0]);
        if (bDk.size() > bDi) {
            boolean z = true;
            for (String str : bDk.subList(0, 2000 >= bDk.size() - bDi ? bDk.size() - bDi : 2000)) {
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

    public static List<String> bDk() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bCU().b("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.e(cursor);
        }
        return arrayList;
    }

    public static boolean yZ(String str) {
        try {
            return h.bCU().yX("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
