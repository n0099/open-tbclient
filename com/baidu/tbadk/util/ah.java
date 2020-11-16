package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class ah {
    private static boolean fyF = false;

    public static boolean a(WeakReference<Context> weakReference, boolean z) {
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (z) {
            return audioManager.requestAudioFocus(null, 3, 2) == 1;
        }
        return audioManager.abandonAudioFocus(null) == 1;
    }

    public static void b(WeakReference<Context> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            fyF = ((AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isMusicActive();
        }
    }

    public static boolean bDt() {
        return fyF;
    }

    public static boolean st(int i) {
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

    public static boolean aI(int i, String str) {
        return st(i);
    }

    public static boolean bDu() {
        if (!com.baidu.adp.lib.util.j.isWifiNet() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }
}
