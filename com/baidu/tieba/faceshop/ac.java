package com.baidu.tieba.faceshop;

import android.webkit.URLUtil;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
final class ac implements Runnable {
    final /* synthetic */ FaceBuyWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.a = faceBuyWebViewActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
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
