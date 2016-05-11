package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aGQ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aGQ.getPageContext();
        j jVar = new j(this);
        relativeLayout = this.aGQ.mRootView;
        p.a(pageContext, jVar, relativeLayout);
    }
}
