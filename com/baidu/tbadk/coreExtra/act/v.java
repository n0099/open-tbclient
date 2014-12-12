package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity Ps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ForgetPwdActivity forgetPwdActivity) {
        this.Ps = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Ps.Pp;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Ps.Pp;
            sapiWebView2.goBack();
            return;
        }
        this.Ps.finish();
    }
}
