package com.baidu.tieba.frs.h5;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BaseWebView.e {
    final /* synthetic */ d bOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bOi = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.bOi.YT();
        this.bOi.bOh = true;
    }
}
