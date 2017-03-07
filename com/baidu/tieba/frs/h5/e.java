package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d bXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bXJ = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bXJ.bXG;
        if (!z) {
            this.bXJ.wK();
            ViewGroup.LayoutParams layoutParams = this.bXJ.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
            this.bXJ.setLayoutParams(layoutParams);
        }
        this.bXJ.bXI = false;
    }
}
