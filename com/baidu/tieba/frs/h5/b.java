package com.baidu.tieba.frs.h5;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends WebChromeClient {
    final /* synthetic */ a cev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cev = aVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        boolean a;
        a = this.cev.a(str2, jsPromptResult);
        return a;
    }
}
