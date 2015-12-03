package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.aFj = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aFj.getPageContext();
        h hVar = new h(this);
        relativeLayout = this.aFj.mRootView;
        j.a(pageContext, hVar, relativeLayout);
    }
}
