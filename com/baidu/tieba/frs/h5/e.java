package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c aZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aZU = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        z = this.aZU.isError;
        if (!z) {
            this.aZU.MX();
            ViewGroup.LayoutParams layoutParams = this.aZU.getLayoutParams();
            layoutParams.height = -2;
            this.aZU.setLayoutParams(layoutParams);
        }
        this.aZU.aZT = true;
    }
}
