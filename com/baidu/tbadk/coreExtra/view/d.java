package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ BaseWebView Tn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebView baseWebView) {
        this.Tn = baseWebView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.Tn.mContext;
                com.baidu.tbadk.browser.a.A(context, str);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        return true;
    }
}
