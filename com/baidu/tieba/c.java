package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aLd = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        LogoActivity.a aVar;
        LogoActivity.a aVar2;
        RelativeLayout relativeLayout;
        View view2;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        View view3;
        view = this.aLd.aKR;
        if (view != null) {
            relativeLayout = this.aLd.mRootView;
            if (relativeLayout != null) {
                view2 = this.aLd.aKR;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aLd.mRootView;
                    view3 = this.aLd.aKR;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aLd.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Ga().ab(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        aVar = this.aLd.aKX;
        eG.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        aVar2 = this.aLd.aKX;
        eG2.postDelayed(aVar2, 3100L);
    }
}
