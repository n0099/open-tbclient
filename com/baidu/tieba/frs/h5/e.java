package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.c {
    final /* synthetic */ c baM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.baM = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        this.baM.auq = false;
        z = this.baM.isError;
        if (!z) {
            this.baM.Nk();
            ViewGroup.LayoutParams layoutParams = this.baM.getLayoutParams();
            layoutParams.height = -2;
            this.baM.setLayoutParams(layoutParams);
        }
        this.baM.baK = true;
    }
}
