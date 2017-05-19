package com.baidu.tieba.frs.e;

import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.cbx = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        boolean z;
        NoPressedRelativeLayout noPressedRelativeLayout;
        Runnable runnable;
        rVar = this.cbx.bPw;
        if (rVar.isAdded()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            rVar2 = this.cbx.bPw;
            Resources resources = rVar2.getResources();
            layoutParams.rightMargin = resources.getDimensionPixelSize(w.f.ds140);
            z = this.cbx.cbn;
            if (z) {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(w.f.ds10) + resources.getDimensionPixelSize(w.f.ds520);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(w.f.ds400);
            }
            noPressedRelativeLayout = this.cbx.caH;
            noPressedRelativeLayout.addView(this.cbx.cbr, layoutParams);
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.cbx.cbw;
            fS.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
