package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity aKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.aKV = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKV.getPageContext();
        h hVar = new h(this);
        relativeLayout = this.aKV.mRootView;
        n.a(pageContext, hVar, relativeLayout);
    }
}
