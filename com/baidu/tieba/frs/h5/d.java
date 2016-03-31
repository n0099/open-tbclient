package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaseWebView.d {
    final /* synthetic */ c bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bsP = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bsP.bsN;
        if (!z) {
            this.bsP.showLoading();
            ViewGroup.LayoutParams layoutParams = this.bsP.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
            this.bsP.setLayoutParams(layoutParams);
        }
        this.bsP.isError = false;
    }
}
