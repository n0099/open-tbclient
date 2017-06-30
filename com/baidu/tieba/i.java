package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aRW = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aRW.getPageContext();
        j jVar = new j(this);
        relativeLayout = this.aRW.mRootView;
        s.a(pageContext, jVar, relativeLayout);
    }
}
