package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aPQ = logoActivity;
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
        view = this.aPQ.aPE;
        if (view != null) {
            relativeLayout = this.aPQ.mRootView;
            if (relativeLayout != null) {
                view2 = this.aPQ.aPE;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aPQ.mRootView;
                    view3 = this.aPQ.aPE;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aPQ.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Go().aa(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        aVar = this.aPQ.aPK;
        fM.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h fM2 = com.baidu.adp.lib.g.h.fM();
        aVar2 = this.aPQ.aPK;
        fM2.postDelayed(aVar2, 3100L);
    }
}
