package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ad {
    private static boolean cDs = false;

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
            cDs = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
        }
    }

    public static boolean awG() {
        return cDs;
    }

    public static boolean kY(int i) {
        boolean z = true;
        switch (i) {
            case 3:
            case 4:
                return com.baidu.adp.lib.util.j.kd();
            case 5:
                return TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || (com.baidu.tbadk.t.z.avR() && com.baidu.adp.lib.util.j.kd() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 0);
            default:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.j.ke() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.j.kd() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("auto_play_video_homepage", 0) == 1) || !com.baidu.adp.lib.util.j.kd()) {
                    z = false;
                }
                return z;
        }
    }

    public static boolean K(int i, String str) {
        return kY(i);
    }

    public static boolean awH() {
        if (!com.baidu.adp.lib.util.j.kd() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return com.baidu.adp.lib.util.j.ke() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }
}
