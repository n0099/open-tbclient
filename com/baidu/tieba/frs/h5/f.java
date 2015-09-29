package com.baidu.tieba.frs.h5;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.e {
    final /* synthetic */ c bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bah = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.bah.showNoData();
        this.bah.isError = true;
    }
}
