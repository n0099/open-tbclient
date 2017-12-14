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
    private static int dJv = TbConfig.POST_IMAGE_SMALL;
    private static int dJw = 500;

    public static void azH() {
        if (!ao.fS()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.azv().azw();
            String azJ = azJ();
            if (!TextUtils.isEmpty(azJ)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mM(azJ), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.azv().endTransaction();
        }
    }

    public static void nj(int i) {
        if (i < dJw) {
            i = dJw;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int azI() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", dJv);
    }

    private static String azJ() {
        List<String> azK;
        StringBuilder sb = new StringBuilder();
        try {
            azK = azK();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (azK == null || azK.size() == 0) {
            return null;
        }
        int azI = azI();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + azK.size() + " max is " + azI, new Object[0]);
        if (azK.size() > azI) {
            boolean z = true;
            for (String str : azK.subList(0, 2000 >= azK.size() - azI ? azK.size() - azI : 2000)) {
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

    private static List<String> azK() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.azv().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    private static boolean mM(String str) {
        try {
            return g.azv().mL("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
