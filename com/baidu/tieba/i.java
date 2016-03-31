package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aKF = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKF.getPageContext();
        j jVar = new j(this);
        relativeLayout = this.aKF.mRootView;
        p.a(pageContext, jVar, relativeLayout);
    }
}
