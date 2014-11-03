package com.baidu.tieba.e;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bf;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String adG() {
        return "key_baobao_count" + TbadkApplication.getCurrentAccount();
    }

    private static String adH() {
        return "key_baobao_last_time" + TbadkApplication.getCurrentAccount();
    }

    public static boolean adI() {
        return !bf.d(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.lk().getLong(adH(), 0L))) || com.baidu.tbadk.core.sharedPref.b.lk().getInt(adG(), 0) < 3;
    }

    public static boolean adJ() {
        return !com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("key_baobao_tip_pb", false);
    }

    public static void adK() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("key_baobao_tip_pb", true);
    }

    public static void adL() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.lk().getLong(adH(), 0L);
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(adH(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.lk().getInt(adG(), 0);
        if (bf.d(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt(adG(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt(adG(), 1);
        }
    }
}
