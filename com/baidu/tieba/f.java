package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ LogoActivity aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.aKF = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKF.getPageContext();
        g gVar = new g(this);
        relativeLayout = this.aKF.mRootView;
        p.a(pageContext, gVar, relativeLayout);
    }
}
