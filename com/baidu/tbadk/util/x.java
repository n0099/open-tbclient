package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class x {
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

    public static boolean fo(int i) {
        boolean z = true;
        switch (i) {
            case 2:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.i.ht() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.i.hs() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) || !com.baidu.adp.lib.util.i.hs()) {
                    z = false;
                }
                return z;
            case 3:
            case 4:
                return com.baidu.adp.lib.util.i.hs();
            case 5:
                return TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || (com.baidu.tbadk.p.p.GS() && com.baidu.adp.lib.util.i.hs() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 0);
            default:
                if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.i.ht() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.i.hs() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_homepage", 0) == 1) || !com.baidu.adp.lib.util.i.hs()) {
                    z = false;
                }
                return z;
        }
    }

    public static boolean r(int i, String str) {
        if (!al.isEmpty(com.baidu.tieba.play.r.hB(str))) {
            if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
                return false;
            }
            return (com.baidu.adp.lib.util.i.ht() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) ? false : true;
        }
        return fo(i);
    }
}
