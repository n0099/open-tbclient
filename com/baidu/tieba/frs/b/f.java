package com.baidu.tieba.frs.b;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BaseWebView.c {
    final /* synthetic */ d bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bZP = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.bZP.isLoading = false;
        z = this.bZP.bZO;
        if (!z) {
            this.bZP.adD();
            ViewGroup.LayoutParams layoutParams = this.bZP.getLayoutParams();
            layoutParams.height = -2;
            this.bZP.setLayoutParams(layoutParams);
        }
        this.bZP.bZM = true;
    }
}
