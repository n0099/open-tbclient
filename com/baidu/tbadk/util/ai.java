package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ai {
    private static boolean eYF = false;

    public static boolean a(WeakReference<Context> weakReference, boolean z) {
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) weakReference.get().getSystemService("audio");
        if (z) {
            return audioManager.requestAudioFocus(null, 3, 2) == 1;
        }
        return audioManager.abandonAudioFocus(null) == 1;
    }

    public static void b(WeakReference<Context> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            eYF = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
        }
    }

    public static boolean bwY() {
        return eYF;
    }

    public static boolean rc(int i) {
        boolean z = false;
        switch (i) {
            case 2:
                int frsAutoPlay = TbadkCoreApplication.getInst().getFrsAutoPlay();
                if (frsAutoPlay == 1 || !com.baidu.adp.lib.util.j.isWifiNet()) {
                    return frsAutoPlay == 2 && com.baidu.adp.lib.util.j.isMobileNet();
                }
                return true;
            case 3:
            case 4:
                return com.baidu.adp.lib.util.j.isWifiNet();
            case 5:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || (FrsHeadVideoAutoPlaySwitch.getIsOn() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 0)) {
                    z = true;
                }
                return z;
            default:
                int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
                if (homePageAutoPlay == 1 || !com.baidu.adp.lib.util.j.isWifiNet()) {
                    return homePageAutoPlay == 2 && com.baidu.adp.lib.util.j.isMobileNet();
                }
                return true;
        }
    }

    public static boolean at(int i, String str) {
        return rc(i);
    }

    public static boolean bwZ() {
        if (!com.baidu.adp.lib.util.j.isWifiNet() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }
}
