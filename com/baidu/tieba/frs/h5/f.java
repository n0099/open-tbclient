package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d ceA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ceA = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.ceA.aAG = false;
        z = this.ceA.cez;
        if (!z) {
            this.ceA.Wq();
            ViewGroup.LayoutParams layoutParams = this.ceA.getLayoutParams();
            layoutParams.height = -2;
            this.ceA.setLayoutParams(layoutParams);
        }
        this.ceA.cex = true;
    }
}
