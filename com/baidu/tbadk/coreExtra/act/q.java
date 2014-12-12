package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity Pr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FillUProfileActivity fillUProfileActivity) {
        this.Pr = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Pr.Pp;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Pr.Pp;
            sapiWebView2.goBack();
            return;
        }
        this.Pr.finish();
    }
}
