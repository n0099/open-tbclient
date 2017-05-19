package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aQB = logoActivity;
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
        view = this.aQB.aQp;
        if (view != null) {
            relativeLayout = this.aQB.mRootView;
            if (relativeLayout != null) {
                view2 = this.aQB.aQp;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aQB.mRootView;
                    view3 = this.aQB.aQp;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aQB.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.j.ab.FQ().ab(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        aVar = this.aQB.aQv;
        fS.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        aVar2 = this.aQB.aQv;
        fS2.postDelayed(aVar2, 3100L);
    }
}
