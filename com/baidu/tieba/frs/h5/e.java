package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bah = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bah.avB = false;
        z = this.bah.isError;
        if (!z) {
            this.bah.MW();
            ViewGroup.LayoutParams layoutParams = this.bah.getLayoutParams();
            layoutParams.height = -2;
            this.bah.setLayoutParams(layoutParams);
        }
        this.bah.baf = true;
    }
}
