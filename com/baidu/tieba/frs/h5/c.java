package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a bQw;
    private final /* synthetic */ h bQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.bQw = aVar;
        this.bQx = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            ba vt = ba.vt();
            baseActivity = this.bQw.aWr;
            if (3 == vt.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            ba vt2 = ba.vt();
            baseActivity2 = this.bQw.aWr;
            vt2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.bQx != null && !TextUtils.isEmpty(this.bQx.stType)) {
                TiebaStatic.log(new ar("c10335").ab("obj_name", this.bQx.stType));
            }
        }
        return true;
    }
}
