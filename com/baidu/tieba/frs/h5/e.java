package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d bQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bQB = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bQB.bQy;
        if (!z) {
            this.bQB.wn();
            ViewGroup.LayoutParams layoutParams = this.bQB.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds90);
            this.bQB.setLayoutParams(layoutParams);
        }
        this.bQB.bQA = false;
    }
}
