package com.baidu.tieba.e;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String adD() {
        return "key_baobao_count" + TbadkApplication.getCurrentAccount();
    }

    private static String adE() {
        return "key_baobao_last_time" + TbadkApplication.getCurrentAccount();
    }

    public static boolean adF() {
        return !be.d(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.lk().getLong(adE(), 0L))) || com.baidu.tbadk.core.sharedPref.b.lk().getInt(adD(), 0) < 3;
    }

    public static boolean adG() {
        return !com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("key_baobao_tip_pb", false);
    }

    public static void adH() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("key_baobao_tip_pb", true);
    }

    public static void adI() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.lk().getLong(adE(), 0L);
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(adE(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.lk().getInt(adD(), 0);
        if (be.d(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt(adD(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt(adD(), 1);
        }
    }
}
