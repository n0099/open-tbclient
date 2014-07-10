package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.g
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.a.mContext;
                com.baidu.tbadk.browser.a.c(context, str);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        return true;
    }
}
