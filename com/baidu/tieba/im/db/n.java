package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.o.as;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int dWD = TbConfig.POST_IMAGE_SMALL;
    private static int dWE = 500;

    public static void aDr() {
        if (!as.fz()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.aDf().aDg();
            String aDt = aDt();
            if (!TextUtils.isEmpty(aDt)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + nu(aDt), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aDf().endTransaction();
        }
    }

    public static void nt(int i) {
        if (i < dWE) {
            i = dWE;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aDs() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", dWD);
    }

    private static String aDt() {
        List<String> aDu;
        StringBuilder sb = new StringBuilder();
        try {
            aDu = aDu();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aDu == null || aDu.size() == 0) {
            return null;
        }
        int aDs = aDs();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aDu.size() + " max is " + aDs, new Object[0]);
        if (aDu.size() > aDs) {
            boolean z = true;
            for (String str : aDu.subList(0, 2000 >= aDu.size() - aDs ? aDu.size() - aDs : 2000)) {
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

    public static List<String> aDu() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.aDf().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean nu(String str) {
        try {
            return h.aDf().nt("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
