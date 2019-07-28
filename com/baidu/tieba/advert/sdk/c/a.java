package com.baidu.tieba.advert.sdk.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        if (0 < j && j < 500) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static void c(AdInfo adInfo) {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", b.a(adInfo).toString()).apply();
    }

    public static void a(b bVar) {
        if (bVar == null) {
            aDW();
        } else {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", bVar.toString()).apply();
        }
    }

    public static void aDW() {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
    }

    public static void aDX() {
        File file = new File(com.baidu.tieba.advert.sdk.b.a.dai);
        if (file.exists()) {
            m.A(file);
        }
    }

    public static void J(File file) {
        File[] listFiles;
        File file2 = new File(com.baidu.tieba.advert.sdk.b.a.dai);
        if (file2.exists() && (listFiles = file2.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3 != null && !file3.equals(file)) {
                    m.A(file3);
                }
            }
        }
    }

    public static String aDY() {
        return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
    }
}
