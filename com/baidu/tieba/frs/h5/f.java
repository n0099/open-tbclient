package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d brD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.brD = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.brD.avz = false;
        z = this.brD.isError;
        if (!z) {
            this.brD.Th();
            ViewGroup.LayoutParams layoutParams = this.brD.getLayoutParams();
            layoutParams.height = -2;
            this.brD.setLayoutParams(layoutParams);
        }
        this.brD.brB = true;
    }
}
