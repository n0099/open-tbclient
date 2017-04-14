package com.baidu.tieba.frs.b;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BaseWebView.e {
    final /* synthetic */ d bXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bXy = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.bXy.acD();
        this.bXy.bXx = true;
    }
}
