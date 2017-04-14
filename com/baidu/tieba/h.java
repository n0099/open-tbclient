package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aQg = logoActivity;
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
        view = this.aQg.aPU;
        if (view != null) {
            relativeLayout = this.aQg.mRootView;
            if (relativeLayout != null) {
                view2 = this.aQg.aPU;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aQg.mRootView;
                    view3 = this.aQg.aPU;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aQg.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.j.ab.GM().aa(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        aVar = this.aQg.aQa;
        fR.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        aVar2 = this.aQg.aQa;
        fR2.postDelayed(aVar2, 3100L);
    }
}
