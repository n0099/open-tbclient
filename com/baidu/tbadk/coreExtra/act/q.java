package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity Kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FillUProfileActivity fillUProfileActivity) {
        this.Kj = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Kj.Kh;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Kj.Kh;
            sapiWebView2.goBack();
            return;
        }
        this.Kj.finish();
    }
}
