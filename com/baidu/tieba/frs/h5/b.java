package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a bsL;
    private final /* synthetic */ g bsM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bsL = aVar;
        this.bsM = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        bg wM = bg.wM();
        baseActivity = this.bsL.bix;
        wM.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bsM != null && !TextUtils.isEmpty(this.bsM.stType)) {
            TiebaStatic.log(new aw("c10335").ac("obj_name", this.bsM.stType));
        }
        return true;
    }
}
