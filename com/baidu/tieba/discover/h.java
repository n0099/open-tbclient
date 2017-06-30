package com.baidu.tieba.discover;

import android.webkit.WebView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BaseWebView.b {
    final /* synthetic */ e bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bPN = eVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean ja;
        this.bPN.iZ(str);
        if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
            return false;
        }
        ja = this.bPN.ja(str);
        if (ja) {
            return true;
        }
        be.vP().c(this.bPN.ajP, new String[]{str});
        return true;
    }
}
