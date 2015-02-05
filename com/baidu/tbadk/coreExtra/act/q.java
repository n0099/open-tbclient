package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity PQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FillUProfileActivity fillUProfileActivity) {
        this.PQ = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.PQ.PO;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.PQ.PO;
            sapiWebView2.goBack();
            return;
        }
        this.PQ.finish();
    }
}
