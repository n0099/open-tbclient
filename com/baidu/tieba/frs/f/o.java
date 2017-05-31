package com.baidu.tieba.frs.f;

import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.chJ = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        boolean z;
        NoPressedRelativeLayout noPressedRelativeLayout;
        Runnable runnable;
        rVar = this.chJ.bVm;
        if (rVar.isAdded()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            rVar2 = this.chJ.bVm;
            Resources resources = rVar2.getResources();
            layoutParams.rightMargin = resources.getDimensionPixelSize(w.f.ds140);
            z = this.chJ.chz;
            if (z) {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(w.f.ds660);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(w.f.ds10) + resources.getDimensionPixelSize(w.f.ds520);
            }
            noPressedRelativeLayout = this.chJ.cgT;
            noPressedRelativeLayout.addView(this.chJ.chD, layoutParams);
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.chJ.chI;
            fS.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
