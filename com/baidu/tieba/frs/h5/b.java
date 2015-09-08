package com.baidu.tieba.frs.h5;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaseWebView.b {
    final /* synthetic */ a bak;
    private final /* synthetic */ g bal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, g gVar) {
        this.bak = aVar;
        this.bal = gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseActivity baseActivity;
        ax uX = ax.uX();
        baseActivity = this.bak.aSX;
        uX.a(baseActivity.getPageContext(), new String[]{str}, true);
        if (this.bal != null && !TextUtils.isEmpty(this.bal.stType)) {
            TiebaStatic.log(new ao("c10335").af("obj_name", this.bal.stType));
        }
        return true;
    }
}
