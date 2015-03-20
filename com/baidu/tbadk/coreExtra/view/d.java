package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ BaseWebView adR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebView baseWebView) {
        this.adR = baseWebView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.adR.mContext;
                com.baidu.tbadk.browser.f.z(context, str);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        return true;
    }
}
