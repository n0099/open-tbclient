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
    final /* synthetic */ a bha;
    private final /* synthetic */ g bhb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bha = aVar;
        this.bhb = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        bf vD = bf.vD();
        baseActivity = this.bha.aXA;
        vD.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bhb != null && !TextUtils.isEmpty(this.bhb.stType)) {
            TiebaStatic.log(new av("c10335").ab("obj_name", this.bhb.stType));
        }
        return true;
    }
}
