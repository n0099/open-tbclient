package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class y {
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

    public static boolean fs(int i) {
        boolean z = true;
        switch (i) {
            case 3:
            case 4:
                return com.baidu.adp.lib.util.j.jF();
            case 5:
                return TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || (com.baidu.tbadk.p.t.Lb() && com.baidu.adp.lib.util.j.jF() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 0);
            default:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.j.jG() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.j.jF() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_homepage", 0) == 1) || !com.baidu.adp.lib.util.j.jF()) {
                    z = false;
                }
                return z;
        }
    }

    public static boolean q(int i, String str) {
        return fs(i);
    }

    public static boolean LI() {
        if (!com.baidu.adp.lib.util.j.jF() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return com.baidu.adp.lib.util.j.jG() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }
}
