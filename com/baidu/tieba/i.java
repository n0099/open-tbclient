package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aLd = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aLd.getPageContext();
        j jVar = new j(this);
        relativeLayout = this.aLd.mRootView;
        n.a(pageContext, jVar, relativeLayout);
    }
}
