package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d cbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cbb = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.cbb.caY;
        if (!z) {
            this.cbb.wn();
            ViewGroup.LayoutParams layoutParams = this.cbb.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds90);
            this.cbb.setLayoutParams(layoutParams);
        }
        this.cbb.cba = false;
    }
}
