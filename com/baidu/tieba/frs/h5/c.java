package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a cev;
    private final /* synthetic */ h cew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.cev = aVar;
        this.cew = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bf vP = bf.vP();
            baseActivity = this.cev.aTb;
            if (3 == vP.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bf vP2 = bf.vP();
            baseActivity2 = this.cev.aTb;
            vP2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.cew != null && !TextUtils.isEmpty(this.cew.stType)) {
                TiebaStatic.log(new av("c10335").ab("obj_name", this.cew.stType));
            }
        }
        return true;
    }
}
