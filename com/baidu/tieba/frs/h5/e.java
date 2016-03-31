package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bsP = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bsP.azx = false;
        z = this.bsP.isError;
        if (!z) {
            this.bsP.SU();
            ViewGroup.LayoutParams layoutParams = this.bsP.getLayoutParams();
            layoutParams.height = -2;
            this.bsP.setLayoutParams(layoutParams);
        }
        this.bsP.bsN = true;
    }
}
