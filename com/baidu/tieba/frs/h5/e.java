package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d brD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.brD = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.brD.brB;
        if (!z) {
            this.brD.showLoading();
            ViewGroup.LayoutParams layoutParams = this.brD.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90);
            this.brD.setLayoutParams(layoutParams);
        }
        this.brD.isError = false;
    }
}
