package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a caW;
    private final /* synthetic */ h caX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.caW = aVar;
        this.caX = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bi vx = bi.vx();
            baseActivity = this.caW.aPR;
            if (3 == vx.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bi vx2 = bi.vx();
            baseActivity2 = this.caW.aPR;
            vx2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.caX != null && !TextUtils.isEmpty(this.caX.stType)) {
                TiebaStatic.log(new ay("c10335").ab("obj_name", this.caX.stType));
            }
        }
        return true;
    }
}
