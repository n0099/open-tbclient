package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aQi = logoActivity;
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
        view = this.aQi.aPW;
        if (view != null) {
            relativeLayout = this.aQi.mRootView;
            if (relativeLayout != null) {
                view2 = this.aQi.aPW;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aQi.mRootView;
                    view3 = this.aQi.aPW;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aQi.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.j.ab.GM().aa(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        aVar = this.aQi.aQc;
        fS.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        aVar2 = this.aQi.aQc;
        fS2.postDelayed(aVar2, 3100L);
    }
}
