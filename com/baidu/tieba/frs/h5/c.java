package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a caY;
    private final /* synthetic */ h caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.caY = aVar;
        this.caZ = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bh vL = bh.vL();
            baseActivity = this.caY.aRd;
            if (3 == vL.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bh vL2 = bh.vL();
            baseActivity2 = this.caY.aRd;
            vL2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.caZ != null && !TextUtils.isEmpty(this.caZ.stType)) {
                TiebaStatic.log(new ax("c10335").ab("obj_name", this.caZ.stType));
            }
        }
        return true;
    }
}
