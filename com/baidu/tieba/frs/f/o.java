package com.baidu.tieba.frs.f;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.ccU = iVar;
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
        frsActivity = this.ccU.bOq;
        layoutParams.rightMargin = frsActivity.getResources().getDimensionPixelSize(w.f.ds140);
        frsActivity2 = this.ccU.bOq;
        layoutParams.bottomMargin = frsActivity2.getResources().getDimensionPixelSize(w.f.ds400);
        noPressedRelativeLayout = this.ccU.ccc;
        noPressedRelativeLayout.addView(this.ccU.ccO, layoutParams);
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.ccU.ccT;
        fM.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
