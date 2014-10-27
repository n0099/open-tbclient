package com.baidu.tieba.faceshop;

import android.webkit.URLUtil;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ FaceBuyWebViewActivity asZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.asZ = faceBuyWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        BaseWebView baseWebView;
        str = this.asZ.mUrl;
        String guessUrl = URLUtil.guessUrl(str);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            baseWebView = this.asZ.mWebView;
            baseWebView.loadUrl(guessUrl);
        }
    }
}
