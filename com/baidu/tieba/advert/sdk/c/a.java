package com.baidu.tieba.advert.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.advert.sdk.data.b;
import java.io.File;
/* loaded from: classes8.dex */
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
            bMH();
        } else {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", bVar.toString()).apply();
        }
    }

    public static void bMH() {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
    }

    public static void bMI() {
        File file = new File(com.baidu.tieba.advert.sdk.b.a.gkY);
        if (file.exists()) {
            o.deleteFileOrDir(file);
        }
    }

    public static void U(File file) {
        File[] listFiles;
        File file2 = new File(com.baidu.tieba.advert.sdk.b.a.gkY);
        if (file2.exists() && (listFiles = file2.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3 != null && !file3.equals(file)) {
                    o.deleteFileOrDir(file3);
                }
            }
        }
    }

    public static String bMJ() {
        return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
    }

    public static void bMK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        if ((i & i2) == i2) {
            layoutParams.addRule(i3);
        }
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            marginLayoutParams.setMargins(l.dip2px(applicationContext, iArr[0]), l.dip2px(applicationContext, iArr[1]), l.dip2px(applicationContext, iArr[2]), l.dip2px(applicationContext, iArr[3]));
        }
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, AdSplashStyle.SplashElement splashElement, AdSplashStyle adSplashStyle, boolean z) {
        AdSplashStyle.a a2 = a(splashElement, adSplashStyle, z);
        if (a2 == null) {
            a2 = new AdSplashStyle.a(a(splashElement, z), b(splashElement, z));
        }
        int i = a2.gravity;
        String str = a2.gkV;
        if (i <= 0) {
            i = a(splashElement, z);
        }
        if (a2.gkW == null || TextUtils.isEmpty(str)) {
            str = b(splashElement, z);
        }
        a2.aQ(i, str);
        Log.i("BESAdSdkSplash", splashElement + "-->isFullScreen=" + z + ",gravity=" + a2.gravity + ",margins=" + a2.gkV);
        a(layoutParams, a2.gravity);
        a(layoutParams, a2.gkW);
    }

    public static AdSplashStyle.a a(AdSplashStyle.SplashElement splashElement, AdSplashStyle adSplashStyle, boolean z) {
        switch (splashElement) {
            case LOGO:
                return z ? adSplashStyle.gkQ : adSplashStyle.gkL;
            case SKIP:
                return z ? adSplashStyle.gkR : adSplashStyle.gkM;
            case LABEL:
                return z ? adSplashStyle.gkS : adSplashStyle.gkN;
            case VOICE:
                return z ? adSplashStyle.gkT : adSplashStyle.gkO;
            case WIFI_TIP:
                return z ? adSplashStyle.gkU : adSplashStyle.gkP;
            default:
                return null;
        }
    }

    public static int a(AdSplashStyle.SplashElement splashElement, boolean z) {
        switch (splashElement) {
            case LOGO:
                return 5;
            case SKIP:
            case WIFI_TIP:
                return 9;
            case LABEL:
                return 6;
            case VOICE:
                return 10;
            default:
                return 0;
        }
    }

    public static String b(AdSplashStyle.SplashElement splashElement, boolean z) {
        switch (splashElement) {
            case LOGO:
                return "15_20_0_0";
            case SKIP:
                return "0_20_15_0";
            case LABEL:
                return z ? "0_0_0_65" : "0_0_0_0";
            case VOICE:
                return "0_0_9_20";
            case WIFI_TIP:
                return "0_58_15_0";
            default:
                return "";
        }
    }
}
