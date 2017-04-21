package com.baidu.tieba.frs.b;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BaseWebView.d {
    final /* synthetic */ d bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bZP = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bZP.bZM;
        if (!z) {
            this.bZP.xg();
            ViewGroup.LayoutParams layoutParams = this.bZP.getLayoutParams();
            layoutParams.height = (k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
            this.bZP.setLayoutParams(layoutParams);
        }
        this.bZP.bZO = false;
    }
}
