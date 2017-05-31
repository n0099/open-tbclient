package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aQD = logoActivity;
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
        view = this.aQD.aQq;
        if (view != null) {
            relativeLayout = this.aQD.mRootView;
            if (relativeLayout != null) {
                view2 = this.aQD.aQq;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aQD.mRootView;
                    view3 = this.aQD.aQq;
                    relativeLayout3.addView(view3);
                }
                relativeLayout2 = this.aQD.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.j.ab.FK().ab(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        aVar = this.aQD.aQx;
        fS.removeCallbacks(aVar);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        aVar2 = this.aQD.aQx;
        fS2.postDelayed(aVar2, 3100L);
    }
}
