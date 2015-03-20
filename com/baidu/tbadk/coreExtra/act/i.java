package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity aap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForgetPwdActivity forgetPwdActivity) {
        this.aap = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.aap.aam;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.aap.aam;
            sapiWebView2.goBack();
            return;
        }
        this.aap.finish();
    }
}
