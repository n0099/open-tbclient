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
    private static int gHw = TbConfig.POST_IMAGE_SMALL;
    private static int gHx = 500;

    public static void bDV() {
        if (!bh.iN()) {
            com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bDI().bDJ();
            String bDX = bDX();
            if (!TextUtils.isEmpty(bDX)) {
                com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + zy(bDX), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bDI().bDK();
        }
    }

    public static void vw(int i) {
        if (i < gHx) {
            i = gHx;
        }
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_max_stranger", i);
    }

    private static int bDW() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_max_stranger", gHw);
    }

    private static String bDX() {
        List<String> bDY;
        StringBuilder sb = new StringBuilder();
        try {
            bDY = bDY();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bDY == null || bDY.size() == 0) {
            return null;
        }
        int bDW = bDW();
        com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bDY.size() + " max is " + bDW, new Object[0]);
        if (bDY.size() > bDW) {
            boolean z = true;
            for (String str : bDY.subList(0, 2000 >= bDY.size() - bDW ? bDY.size() - bDW : 2000)) {
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

    public static List<String> bDY() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bDI().b("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean zy(String str) {
        try {
            return h.bDI().zw("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
