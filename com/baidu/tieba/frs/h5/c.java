package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a bKe;
    private final /* synthetic */ h bKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.bKe = aVar;
        this.bKf = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bc vz = bc.vz();
            baseActivity = this.bKe.aSs;
            if (3 == vz.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bc vz2 = bc.vz();
            baseActivity2 = this.bKe.aSs;
            vz2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.bKf != null && !TextUtils.isEmpty(this.bKf.stType)) {
                TiebaStatic.log(new at("c10335").ab("obj_name", this.bKf.stType));
            }
        }
        return true;
    }
}
