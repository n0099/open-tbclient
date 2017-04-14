package com.baidu.tieba.frs.b;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bXy = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bXy.isLoading = false;
        z = this.bXy.bXx;
        if (!z) {
            this.bXy.acC();
            ViewGroup.LayoutParams layoutParams = this.bXy.getLayoutParams();
            layoutParams.height = -2;
            this.bXy.setLayoutParams(layoutParams);
        }
        this.bXy.bXv = true;
    }
}
