package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.ao;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static int evF = TbConfig.POST_IMAGE_SMALL;
    private static int evG = 500;

    public static void aGI() {
        if (!ao.nu()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.aGw().aGx();
            String aGK = aGK();
            if (!TextUtils.isEmpty(aGK)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mV(aGK), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.aGw().endTransaction();
        }
    }

    public static void qb(int i) {
        if (i < evG) {
            i = evG;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aGJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", evF);
    }

    private static String aGK() {
        List<String> aGL;
        StringBuilder sb = new StringBuilder();
        try {
            aGL = aGL();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aGL == null || aGL.size() == 0) {
            return null;
        }
        int aGJ = aGJ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aGL.size() + " max is " + aGJ, new Object[0]);
        if (aGL.size() > aGJ) {
            boolean z = true;
            for (String str : aGL.subList(0, 2000 >= aGL.size() - aGJ ? aGL.size() - aGJ : 2000)) {
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

    private static List<String> aGL() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.aGw().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            n.i(cursor);
        }
        return arrayList;
    }

    private static boolean mV(String str) {
        try {
            return g.aGw().mU("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
