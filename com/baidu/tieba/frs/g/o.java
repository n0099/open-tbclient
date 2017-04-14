package com.baidu.tieba.frs.g;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.cbv = iVar;
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
        frsActivity = this.cbv.bOf;
        layoutParams.rightMargin = frsActivity.getResources().getDimensionPixelSize(w.f.ds140);
        frsActivity2 = this.cbv.bOf;
        layoutParams.bottomMargin = frsActivity2.getResources().getDimensionPixelSize(w.f.ds400);
        noPressedRelativeLayout = this.cbv.caD;
        noPressedRelativeLayout.addView(this.cbv.cbp, layoutParams);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.cbv.cbu;
        fR.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
