package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d cbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cbb = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.cbb.aAl = false;
        z = this.cbb.cba;
        if (!z) {
            this.cbb.UV();
            ViewGroup.LayoutParams layoutParams = this.cbb.getLayoutParams();
            layoutParams.height = -2;
            this.cbb.setLayoutParams(layoutParams);
        }
        this.cbb.caY = true;
    }
}
