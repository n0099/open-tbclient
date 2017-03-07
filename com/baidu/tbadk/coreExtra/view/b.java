package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ BaseWebView asF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebView baseWebView) {
        this.asF = baseWebView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.asF.mContext;
                com.baidu.tbadk.browser.f.Q(context, str);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        return true;
    }
}
