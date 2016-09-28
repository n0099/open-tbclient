package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d cbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cbd = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.cbd.azO = false;
        z = this.cbd.cbc;
        if (!z) {
            this.cbd.Vo();
            ViewGroup.LayoutParams layoutParams = this.cbd.getLayoutParams();
            layoutParams.height = -2;
            this.cbd.setLayoutParams(layoutParams);
        }
        this.cbd.cba = true;
    }
}
