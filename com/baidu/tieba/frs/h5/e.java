package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d bOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bOi = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bOi.bOf;
        if (!z) {
            this.bOi.vj();
            ViewGroup.LayoutParams layoutParams = this.bOi.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds90);
            this.bOi.setLayoutParams(layoutParams);
        }
        this.bOi.bOh = false;
    }
}
