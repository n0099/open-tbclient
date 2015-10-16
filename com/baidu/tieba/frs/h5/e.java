package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c bat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bat = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bat.avC = false;
        z = this.bat.isError;
        if (!z) {
            this.bat.MW();
            ViewGroup.LayoutParams layoutParams = this.bat.getLayoutParams();
            layoutParams.height = -2;
            this.bat.setLayoutParams(layoutParams);
        }
        this.bat.baq = true;
    }
}
