package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements BaseWebView.b {
    final /* synthetic */ a bOd;
    private final /* synthetic */ h bOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, h hVar) {
        this.bOd = aVar;
        this.bOe = hVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        bi us = bi.us();
        baseActivity = this.bOd.bkc;
        us.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bOe != null && !TextUtils.isEmpty(this.bOe.stType)) {
            TiebaStatic.log(new ay("c10335").ab("obj_name", this.bOe.stType));
        }
        return true;
    }
}
