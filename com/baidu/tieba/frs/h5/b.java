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
    final /* synthetic */ a baI;
    private final /* synthetic */ g baJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.baI = aVar;
        this.baJ = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        az uX = az.uX();
        baseActivity = this.baI.aSm;
        uX.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.baJ != null && !TextUtils.isEmpty(this.baJ.stType)) {
            TiebaStatic.log(new aq("c10335").ae("obj_name", this.baJ.stType));
        }
        return true;
    }
}
