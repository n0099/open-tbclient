package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.play.at;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class w {
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
        switch (i) {
            case 1:
            case 2:
                return (com.baidu.adp.lib.util.i.hg() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hf() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
            case 3:
            case 4:
                return com.baidu.adp.lib.util.i.hf();
            case 5:
                return TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2 || (com.baidu.tbadk.switchs.o.GB() && com.baidu.adp.lib.util.i.hf() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 0);
            default:
                return (com.baidu.adp.lib.util.i.hg() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hf() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
        }
    }

    public static boolean q(int i, String str) {
        if (!au.isEmpty(at.gT(str))) {
            if (TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 1) {
                return false;
            }
            return (com.baidu.adp.lib.util.i.hg() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 0) ? false : true;
        }
        return fh(i);
    }
}
