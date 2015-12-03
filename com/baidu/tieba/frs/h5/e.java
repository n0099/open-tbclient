package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bhe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bhe = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bhe.awu = false;
        z = this.bhe.isError;
        if (!z) {
            this.bhe.OM();
            ViewGroup.LayoutParams layoutParams = this.bhe.getLayoutParams();
            layoutParams.height = -2;
            this.bhe.setLayoutParams(layoutParams);
        }
        this.bhe.bhc = true;
    }
}
