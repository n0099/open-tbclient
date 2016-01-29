package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a bnO;
    private final /* synthetic */ g bnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bnO = aVar;
        this.bnP = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        be wt = be.wt();
        baseActivity = this.bnO.bdK;
        wt.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bnP != null && !TextUtils.isEmpty(this.bnP.stType)) {
            TiebaStatic.log(new au("c10335").aa("obj_name", this.bnP.stType));
        }
        return true;
    }
}
