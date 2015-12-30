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
public class b implements BaseWebView.b {
    final /* synthetic */ a bkR;
    private final /* synthetic */ g bkS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bkR = aVar;
        this.bkS = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        bf vn = bf.vn();
        baseActivity = this.bkR.bbA;
        vn.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bkS != null && !TextUtils.isEmpty(this.bkS.stType)) {
            TiebaStatic.log(new av("c10335").aa("obj_name", this.bkS.stType));
        }
        return true;
    }
}
