package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a bao;
    private final /* synthetic */ g bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bao = aVar;
        this.bap = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        az uW = az.uW();
        baseActivity = this.bao.aSe;
        uW.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bap != null && !TextUtils.isEmpty(this.bap.stType)) {
            TiebaStatic.log(new aq("c10335").ae("obj_name", this.bap.stType));
        }
        return true;
    }
}
