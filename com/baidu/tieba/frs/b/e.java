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
    final /* synthetic */ d bXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bXy = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void a(WebView webView, String str) {
        boolean z;
        z = this.bXy.bXv;
        if (!z) {
            this.bXy.xg();
            ViewGroup.LayoutParams layoutParams = this.bXy.getLayoutParams();
            layoutParams.height = (k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
            this.bXy.setLayoutParams(layoutParams);
        }
        this.bXy.bXx = false;
    }
}
