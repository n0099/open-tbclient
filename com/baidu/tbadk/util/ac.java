package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ac {
    private static boolean cPu = false;

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

    public static void c(WeakReference<Context> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            cPu = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
        }
    }

    public static boolean axU() {
        return cPu;
    }

    public static boolean ko(int i) {
        boolean z = true;
        switch (i) {
            case 3:
            case 4:
                return com.baidu.adp.lib.util.j.isWifiNet();
            case 5:
                return TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || (com.baidu.tbadk.t.z.axk() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 0);
            default:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE, 0) == 1) || !com.baidu.adp.lib.util.j.isWifiNet()) {
                    z = false;
                }
                return z;
        }
    }

    public static boolean N(int i, String str) {
        return ko(i);
    }

    public static boolean axV() {
        if (!com.baidu.adp.lib.util.j.isWifiNet() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }
}
