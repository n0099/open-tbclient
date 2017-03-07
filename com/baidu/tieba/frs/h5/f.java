package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bXJ = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bXJ.isLoading = false;
        z = this.bXJ.bXI;
        if (!z) {
            this.bXJ.acg();
            ViewGroup.LayoutParams layoutParams = this.bXJ.getLayoutParams();
            layoutParams.height = -2;
            this.bXJ.setLayoutParams(layoutParams);
        }
        this.bXJ.bXG = true;
    }
}
