package com.baidu.tieba.frs.h5;

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
    final /* synthetic */ a bXE;
    private final /* synthetic */ h bXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.bXE = aVar;
        this.bXF = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if ((webView.getTag() instanceof Integer) && 3 == ((Integer) webView.getTag()).intValue()) {
            webView.setTag(-1);
        } else {
            bb vQ = bb.vQ();
            baseActivity = this.bXE.bcF;
            if (3 == vQ.b(baseActivity.getPageContext(), new String[]{str})) {
                webView.setTag(3);
            }
            bb vQ2 = bb.vQ();
            baseActivity2 = this.bXE.bcF;
            vQ2.a(baseActivity2.getPageContext(), new String[]{str}, true);
            if (this.bXF != null && !TextUtils.isEmpty(this.bXF.stType)) {
                TiebaStatic.log(new as("c10335").Z("obj_name", this.bXF.stType));
            }
        }
        return true;
    }
}
