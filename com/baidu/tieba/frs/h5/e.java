package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bkV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bkV = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bkV.axY = false;
        z = this.bkV.isError;
        if (!z) {
            this.bkV.Pe();
            ViewGroup.LayoutParams layoutParams = this.bkV.getLayoutParams();
            layoutParams.height = -2;
            this.bkV.setLayoutParams(layoutParams);
        }
        this.bkV.bkT = true;
    }
}
