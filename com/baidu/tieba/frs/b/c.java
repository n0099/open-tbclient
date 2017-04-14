package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a bXt;
    private final /* synthetic */ h bXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.bXt = aVar;
        this.bXu = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bb wn = bb.wn();
            baseActivity = this.bXt.bcy;
            if (3 == wn.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bb wn2 = bb.wn();
            baseActivity2 = this.bXt.bcy;
            wn2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.bXu != null && !TextUtils.isEmpty(this.bXu.stType)) {
                TiebaStatic.log(new as("c10335").aa("obj_name", this.bXu.stType));
            }
        }
        return true;
    }
}
