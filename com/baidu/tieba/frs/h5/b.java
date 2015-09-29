package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a bad;
    private final /* synthetic */ g bae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bad = aVar;
        this.bae = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        ay uV = ay.uV();
        baseActivity = this.bad.aRT;
        uV.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bae != null && !TextUtils.isEmpty(this.bae.stType)) {
            TiebaStatic.log(new ap("c10335").ae("obj_name", this.bae.stType));
        }
        return true;
    }
}
