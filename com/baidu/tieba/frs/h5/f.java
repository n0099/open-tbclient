package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bPT = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bPT.axe = false;
        z = this.bPT.bPS;
        if (!z) {
            this.bPT.Qj();
            ViewGroup.LayoutParams layoutParams = this.bPT.getLayoutParams();
            layoutParams.height = -2;
            this.bPT.setLayoutParams(layoutParams);
        }
        this.bPT.bPQ = true;
    }
}
