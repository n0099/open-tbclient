package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class z {
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

    public static boolean fh(int i) {
        boolean z = true;
        switch (i) {
            case 2:
                if (TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) || !com.baidu.adp.lib.util.i.hl()) {
                    z = false;
                }
                return z;
            case 3:
            case 4:
                return com.baidu.adp.lib.util.i.hl();
            case 5:
                return TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() == 2 || (com.baidu.tbadk.n.p.FX() && com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() == 0);
            default:
                if (TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() != -1) {
                    return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlayReal() != 1);
                }
                if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_homepage", 0) == 1) || !com.baidu.adp.lib.util.i.hl()) {
                    z = false;
                }
                return z;
        }
    }

    public static boolean r(int i, String str) {
        if (!au.isEmpty(com.baidu.tieba.play.au.gQ(str))) {
            if (TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 1) {
                return false;
            }
            return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 0) ? false : true;
        }
        return fh(i);
    }
}
