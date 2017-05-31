package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aQD = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQD.getPageContext();
        j jVar = new j(this);
        relativeLayout = this.aQD.mRootView;
        s.a(pageContext, jVar, relativeLayout);
    }
}
