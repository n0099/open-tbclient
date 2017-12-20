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

    public static void azG() {
        if (!ao.fS()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            g.azu().azv();
            String azI = azI();
            if (!TextUtils.isEmpty(azI)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + mM(azI), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.azu().endTransaction();
        }
    }

    public static void nj(int i) {
        if (i < dJw) {
            i = dJw;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int azH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", dJv);
    }

    private static String azI() {
        List<String> azJ;
        StringBuilder sb = new StringBuilder();
        try {
            azJ = azJ();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (azJ == null || azJ.size() == 0) {
            return null;
        }
        int azH = azH();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + azJ.size() + " max is " + azH, new Object[0]);
        if (azJ.size() > azH) {
            boolean z = true;
            for (String str : azJ.subList(0, 2000 >= azJ.size() - azH ? azJ.size() - azH : 2000)) {
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

    private static List<String> azJ() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = g.azu().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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
            return g.azu().mL("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
