package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aKf = logoActivity;
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
        view = this.aKf.aJT;
        if (view != null) {
            relativeLayout = this.aKf.mRootView;
            if (relativeLayout != null) {
                view2 = this.aKf.aJT;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aKf.mRootView;
                    view3 = this.aKf.aJT;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aKf.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.FU().aa(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        aVar = this.aKf.aJZ;
        eE.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h eE2 = com.baidu.adp.lib.g.h.eE();
        aVar2 = this.aKf.aJZ;
        eE2.postDelayed(aVar2, 3100L);
    }
}
