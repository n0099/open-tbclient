package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ LogoActivity aKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LogoActivity logoActivity) {
        this.aKV = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aKV.getPageContext();
        e eVar = new e(this);
        relativeLayout = this.aKV.mRootView;
        n.a(pageContext, eVar, relativeLayout);
    }
}
