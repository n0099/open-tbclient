package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity Ki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FillUProfileActivity fillUProfileActivity) {
        this.Ki = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Ki.Kg;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Ki.Kg;
            sapiWebView2.goBack();
            return;
        }
        this.Ki.finish();
    }
}
