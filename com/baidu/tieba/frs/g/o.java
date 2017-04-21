package com.baidu.tieba.frs.g;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.cdM = iVar;
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
        frsActivity = this.cdM.bQw;
        layoutParams.rightMargin = frsActivity.getResources().getDimensionPixelSize(w.f.ds140);
        frsActivity2 = this.cdM.bQw;
        layoutParams.bottomMargin = frsActivity2.getResources().getDimensionPixelSize(w.f.ds400);
        noPressedRelativeLayout = this.cdM.ccU;
        noPressedRelativeLayout.addView(this.cdM.cdG, layoutParams);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.cdM.cdL;
        fS.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
