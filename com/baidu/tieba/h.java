package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.aRW = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        LogoActivity.a aVar;
        View view2;
        LogoActivity.a aVar2;
        int i;
        View view3;
        View view4;
        RelativeLayout relativeLayout;
        View view5;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        View view6;
        view = this.aRW.aRJ;
        if (view != null) {
            relativeLayout = this.aRW.mRootView;
            if (relativeLayout != null) {
                view5 = this.aRW.aRJ;
                if (view5.getParent() == null) {
                    relativeLayout3 = this.aRW.mRootView;
                    view6 = this.aRW.aRJ;
                    relativeLayout3.addView(view6);
                }
                relativeLayout2 = this.aRW.mRootView;
                relativeLayout2.setFocusable(true);
                com.baidu.tbadk.j.ab.Gh().ac(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        aVar = this.aRW.aRQ;
        fR.removeCallbacks(aVar);
        view2 = this.aRW.aRJ;
        if (view2 != null) {
            view3 = this.aRW.aRJ;
            if (view3.getTag() instanceof Boolean) {
                view4 = this.aRW.aRJ;
                if (((Boolean) view4.getTag()).booleanValue()) {
                    this.aRW.aRI = 6100;
                } else {
                    this.aRW.aRI = 3100;
                }
            }
        }
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        aVar2 = this.aRW.aRQ;
        i = this.aRW.aRI;
        fR2.postDelayed(aVar2, i);
    }
}
