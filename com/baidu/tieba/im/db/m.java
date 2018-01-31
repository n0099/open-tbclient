package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static int exz = TbConfig.POST_IMAGE_SMALL;
    private static int exA = 500;

    public static void aGS() {
        if (!ap.nv()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.aGG().aGH();
            String aGU = aGU();
            if (!TextUtils.isEmpty(aGU)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + nf(aGU), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.aGG().endTransaction();
        }
    }

    public static void pU(int i) {
        if (i < exA) {
            i = exA;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aGT() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", exz);
    }

    private static String aGU() {
        List<String> aGV;
        StringBuilder sb = new StringBuilder();
        try {
            aGV = aGV();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aGV == null || aGV.size() == 0) {
            return null;
        }
        int aGT = aGT();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aGV.size() + " max is " + aGT, new Object[0]);
        if (aGV.size() > aGT) {
            boolean z = true;
            for (String str : aGV.subList(0, 2000 >= aGV.size() - aGT ? aGV.size() - aGT : 2000)) {
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

    private static List<String> aGV() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.aGG().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    private static boolean nf(String str) {
        try {
            return g.aGG().ne("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
