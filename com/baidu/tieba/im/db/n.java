package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.p.az;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static int eNQ = TbConfig.POST_IMAGE_SMALL;
    private static int eNR = 500;

    public static void aQI() {
        if (!az.jJ()) {
            com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
            return;
        }
        try {
            h.aQw().aQx();
            String aQK = aQK();
            if (!TextUtils.isEmpty(aQK)) {
                com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + qa(aQK), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aQw().endTransaction();
        }
    }

    public static void pO(int i) {
        if (i < eNR) {
            i = eNR;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_max_stranger", i);
    }

    private static int aQJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_max_stranger", eNQ);
    }

    private static String aQK() {
        List<String> aQL;
        StringBuilder sb = new StringBuilder();
        try {
            aQL = aQL();
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (aQL == null || aQL.size() == 0) {
            return null;
        }
        int aQJ = aQJ();
        com.baidu.tbadk.core.d.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + aQL.size() + " max is " + aQJ, new Object[0]);
        if (aQL.size() > aQJ) {
            boolean z = true;
            for (String str : aQL.subList(0, 2000 >= aQL.size() - aQJ ? aQL.size() - aQJ : 2000)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static List<String> aQL() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.aQw().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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

    public static boolean qa(String str) {
        try {
            return h.aQw().pZ("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }
}
