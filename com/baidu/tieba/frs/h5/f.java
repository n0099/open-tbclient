package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bQB = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bQB.isLoading = false;
        z = this.bQB.bQA;
        if (!z) {
            this.bQB.abj();
            ViewGroup.LayoutParams layoutParams = this.bQB.getLayoutParams();
            layoutParams.height = -2;
            this.bQB.setLayoutParams(layoutParams);
        }
        this.bQB.bQy = true;
    }
}
