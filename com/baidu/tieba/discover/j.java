package com.baidu.tieba.discover;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements BaseWebView.c {
    final /* synthetic */ e bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bPN = eVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        this.bPN.Nm();
        if (com.baidu.adp.lib.util.i.hj()) {
            this.bPN.UM();
            this.bPN.yB = true;
        }
    }
}
