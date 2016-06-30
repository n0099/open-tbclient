package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bOi = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bOi.awp = false;
        z = this.bOi.bOh;
        if (!z) {
            this.bOi.PF();
            ViewGroup.LayoutParams layoutParams = this.bOi.getLayoutParams();
            layoutParams.height = -2;
            this.bOi.setLayoutParams(layoutParams);
        }
        this.bOi.bOf = true;
    }
}
