package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.s.bb;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int ghz = TbConfig.POST_IMAGE_SMALL;
    private static int ghA = 500;

    public static void bsB() {
        if (!bb.jK()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bsp().bsq();
            String bsD = bsD();
            if (!TextUtils.isEmpty(bsD)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + wZ(bsD), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bsp().endTransaction();
        }
    }

    public static void tM(int i) {
        if (i < ghA) {
            i = ghA;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int bsC() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", ghz);
    }

    private static String bsD() {
        List<String> bsE;
        StringBuilder sb = new StringBuilder();
        try {
            bsE = bsE();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bsE == null || bsE.size() == 0) {
            return null;
        }
        int bsC = bsC();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bsE.size() + " max is " + bsC, new Object[0]);
        if (bsE.size() > bsC) {
            boolean z = true;
            for (String str : bsE.subList(0, 2000 >= bsE.size() - bsC ? bsE.size() - bsC : 2000)) {
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

    public static List<String> bsE() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bsp().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean wZ(String str) {
        try {
            return h.bsp().wY("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
