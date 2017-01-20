package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ LogoActivity aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LogoActivity logoActivity) {
        this.aKf = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKf.getPageContext();
        e eVar = new e(this);
        relativeLayout = this.aKf.mRootView;
        n.a(pageContext, eVar, relativeLayout);
    }
}
