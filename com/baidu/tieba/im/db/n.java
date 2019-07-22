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
    private static int gEM = TbConfig.POST_IMAGE_SMALL;
    private static int gEN = 500;

    public static void bCT() {
        if (!bh.iN()) {
            com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.bCG().bCH();
            String bCV = bCV();
            if (!TextUtils.isEmpty(bCV)) {
                com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + yY(bCV), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCG().bCI();
        }
    }

    public static void vq(int i) {
        if (i < gEN) {
            i = gEN;
        }
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_max_stranger", i);
    }

    private static int bCU() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_max_stranger", gEM);
    }

    private static String bCV() {
        List<String> bCW;
        StringBuilder sb = new StringBuilder();
        try {
            bCW = bCW();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (bCW == null || bCW.size() == 0) {
            return null;
        }
        int bCU = bCU();
        com.baidu.tbadk.core.e.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + bCW.size() + " max is " + bCU, new Object[0]);
        if (bCW.size() > bCU) {
            boolean z = true;
            for (String str : bCW.subList(0, 2000 >= bCW.size() - bCU ? bCW.size() - bCU : 2000)) {
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

    public static List<String> bCW() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.bCG().b("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean yY(String str) {
        try {
            return h.bCG().yW("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
