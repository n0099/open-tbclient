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
    private static int gyz = TbConfig.POST_IMAGE_SMALL;
    private static int gyA = 500;

    public static void bAm() {
        if (!bh.iE()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bAa().bAb();
            String bAo = bAo();
            if (!TextUtils.isEmpty(bAo)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + yl(bAo), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAa().endTransaction();
        }
    }

    public static void uP(int i) {
        if (i < gyA) {
            i = gyA;
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_max_stranger", i);
    }

    private static int bAn() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_max_stranger", gyz);
    }

    private static String bAo() {
        List<String> bAp;
        StringBuilder sb = new StringBuilder();
        try {
            bAp = bAp();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bAp == null || bAp.size() == 0) {
            return null;
        }
        int bAn = bAn();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bAp.size() + " max is " + bAn, new Object[0]);
        if (bAp.size() > bAn) {
            boolean z = true;
            for (String str : bAp.subList(0, 2000 >= bAp.size() - bAn ? bAp.size() - bAn : 2000)) {
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

    public static List<String> bAp() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bAa().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean yl(String str) {
        try {
            return h.bAa().yk("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
