package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.p.an;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static int dAE = TbConfig.POST_IMAGE_SMALL;
    private static int dAF = 500;

    public static void axY() {
        if (!an.fS()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.axM().axN();
            String aya = aya();
            if (!TextUtils.isEmpty(aya)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mD(aya), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.axM().endTransaction();
        }
    }

    public static void mO(int i) {
        if (i < dAF) {
            i = dAF;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int axZ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", dAE);
    }

    private static String aya() {
        List<String> ayb;
        StringBuilder sb = new StringBuilder();
        try {
            ayb = ayb();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (ayb == null || ayb.size() == 0) {
            return null;
        }
        int axZ = axZ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + ayb.size() + " max is " + axZ, new Object[0]);
        if (ayb.size() > axZ) {
            boolean z = true;
            for (String str : ayb.subList(0, 2000 >= ayb.size() - axZ ? ayb.size() - axZ : 2000)) {
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

    private static List<String> ayb() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.axM().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
        } finally {
            n.e(cursor);
        }
        return arrayList;
    }

    private static boolean mD(String str) {
        try {
            return g.axM().mC("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
