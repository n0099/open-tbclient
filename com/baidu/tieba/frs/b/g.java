package com.baidu.tieba.frs.b;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BaseWebView.e {
    final /* synthetic */ d bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bZP = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.bZP.adE();
        this.bZP.bZO = true;
    }
}
