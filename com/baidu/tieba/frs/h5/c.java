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
public class c implements BaseWebView.b {
    private final /* synthetic */ h brA;
    final /* synthetic */ a brz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.brz = aVar;
        this.brA = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        bg us = bg.us();
        baseActivity = this.brz.bek;
        us.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.brA != null && !TextUtils.isEmpty(this.brA.stType)) {
            TiebaStatic.log(new aw("c10335").ac("obj_name", this.brA.stType));
        }
        return true;
    }
}
