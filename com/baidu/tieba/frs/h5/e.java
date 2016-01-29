package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bnS = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bnS.ayQ = false;
        z = this.bnS.isError;
        if (!z) {
            this.bnS.Rh();
            ViewGroup.LayoutParams layoutParams = this.bnS.getLayoutParams();
            layoutParams.height = -2;
            this.bnS.setLayoutParams(layoutParams);
        }
        this.bnS.bnQ = true;
    }
}
