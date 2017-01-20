package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.aKf = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKf.getPageContext();
        h hVar = new h(this);
        relativeLayout = this.aKf.mRootView;
        n.a(pageContext, hVar, relativeLayout);
    }
}
