package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.play.at;
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

    public static boolean fg(int i) {
        switch (i) {
            case 1:
            case 2:
                return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
            case 3:
            case 4:
                return com.baidu.adp.lib.util.i.hl();
            case 5:
                return TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2 || (com.baidu.tbadk.n.o.Gd() && com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 0);
            default:
                return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
        }
    }

    public static boolean r(int i, String str) {
        if (!au.isEmpty(at.gV(str))) {
            if (TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 1) {
                return false;
            }
            return (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 0) ? false : true;
        }
        return fg(i);
    }
}
