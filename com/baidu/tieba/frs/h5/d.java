package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaseWebView.d {
    final /* synthetic */ c bat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bat = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bat.baq;
        if (!z) {
            this.bat.showLoading();
            ViewGroup.LayoutParams layoutParams = this.bat.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
            this.bat.setLayoutParams(layoutParams);
        }
        this.bat.isError = false;
    }
}
