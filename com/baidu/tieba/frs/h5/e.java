package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bao = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bao.axc = false;
        z = this.bao.isError;
        if (!z) {
            this.bao.MX();
            ViewGroup.LayoutParams layoutParams = this.bao.getLayoutParams();
            layoutParams.height = -2;
            this.bao.setLayoutParams(layoutParams);
        }
        this.bao.bam = true;
    }
}
