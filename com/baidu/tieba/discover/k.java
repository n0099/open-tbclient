package com.baidu.tieba.discover;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class k implements BaseWebView.e {
    final /* synthetic */ e bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bPN = eVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.bPN.Va();
    }
}
