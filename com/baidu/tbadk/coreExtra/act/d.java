package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity aao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FillUProfileActivity fillUProfileActivity) {
        this.aao = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.aao.aam;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.aao.aam;
            sapiWebView2.goBack();
            return;
        }
        this.aao.finish();
    }
}
