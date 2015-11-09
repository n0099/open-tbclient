package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaseWebView.d {
    final /* synthetic */ c baM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.baM = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.baM.baK;
        if (!z) {
            this.baM.showLoading();
            ViewGroup.LayoutParams layoutParams = this.baM.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
            this.baM.setLayoutParams(layoutParams);
        }
        this.baM.isError = false;
    }
}
