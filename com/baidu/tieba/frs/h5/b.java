package com.baidu.tieba.frs.h5;

import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aZS = aVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        ax uR = ax.uR();
        baseActivity = this.aZS.aSJ;
        uR.a(baseActivity.getPageContext(), new String[]{str}, true);
        return true;
    }
}
