package com.baidu.tieba.faceshop;

import android.webkit.URLUtil;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ FaceBuyWebViewActivity ati;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.ati = faceBuyWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        BaseWebView baseWebView;
        str = this.ati.mUrl;
        String guessUrl = URLUtil.guessUrl(str);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            baseWebView = this.ati.mWebView;
            baseWebView.loadUrl(guessUrl);
        }
    }
}
