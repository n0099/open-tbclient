package com.baidu.tieba.frs.f;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.bVC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        NoPressedRelativeLayout noPressedRelativeLayout;
        Runnable runnable;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        frsActivity = this.bVC.bHh;
        layoutParams.rightMargin = frsActivity.getResources().getDimensionPixelSize(r.f.ds140);
        frsActivity2 = this.bVC.bHh;
        layoutParams.bottomMargin = frsActivity2.getResources().getDimensionPixelSize(r.f.ds400);
        noPressedRelativeLayout = this.bVC.bUK;
        noPressedRelativeLayout.addView(this.bVC.bVw, layoutParams);
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.bVC.bVB;
        eE.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
