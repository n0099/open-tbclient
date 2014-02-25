package com.baidu.tieba.faceshop;

import android.webkit.URLUtil;
import com.baidu.tieba.view.BaseWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FaceBuyWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.a = faceBuyWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        BaseWebView baseWebView;
        str = this.a.c;
        String guessUrl = URLUtil.guessUrl(str);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            baseWebView = this.a.a;
            baseWebView.loadUrl(guessUrl);
        }
    }
}
