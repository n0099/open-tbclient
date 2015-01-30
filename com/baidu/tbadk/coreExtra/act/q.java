package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity PU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FillUProfileActivity fillUProfileActivity) {
        this.PU = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.PU.PR;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.PU.PR;
            sapiWebView2.goBack();
            return;
        }
        this.PU.finish();
    }
}
