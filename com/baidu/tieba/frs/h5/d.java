package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaseWebView.d {
    final /* synthetic */ c bkV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bkV = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bkV.bkT;
        if (!z) {
            this.bkV.showLoading();
            ViewGroup.LayoutParams layoutParams = this.bkV.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
            this.bkV.setLayoutParams(layoutParams);
        }
        this.bkV.isError = false;
    }
}
