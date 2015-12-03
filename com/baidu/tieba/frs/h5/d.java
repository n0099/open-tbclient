package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaseWebView.d {
    final /* synthetic */ c bhe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bhe = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bhe.bhc;
        if (!z) {
            this.bhe.showLoading();
            ViewGroup.LayoutParams layoutParams = this.bhe.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90);
            this.bhe.setLayoutParams(layoutParams);
        }
        this.bhe.isError = false;
    }
}
