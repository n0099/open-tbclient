package com.baidu.tieba.frs.h5;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bPT = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bPT.bPQ;
        if (!z) {
            this.bPT.vj();
            ViewGroup.LayoutParams layoutParams = this.bPT.getLayoutParams();
            layoutParams.height = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds90);
            this.bPT.setLayoutParams(layoutParams);
        }
        this.bPT.bPS = false;
    }
}
