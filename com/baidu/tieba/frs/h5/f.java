package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bKj = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bKj.aAd = false;
        z = this.bKj.bKi;
        if (!z) {
            this.bKj.aae();
            ViewGroup.LayoutParams layoutParams = this.bKj.getLayoutParams();
            layoutParams.height = -2;
            this.bKj.setLayoutParams(layoutParams);
        }
        this.bKj.bKg = true;
    }
}
