package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d ceA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ceA = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.ceA.cex;
        if (!z) {
            this.ceA.wI();
            ViewGroup.LayoutParams layoutParams = this.ceA.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90);
            this.ceA.setLayoutParams(layoutParams);
        }
        this.ceA.cez = false;
    }
}
