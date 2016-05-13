package com.baidu.tbadk.vcode;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ CommonVcodeActivity aAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonVcodeActivity commonVcodeActivity) {
        this.aAJ = commonVcodeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        baseWebView = this.aAJ.mWebView;
        if (baseWebView == null) {
            return;
        }
        this.aAJ.FN();
        baseWebView2 = this.aAJ.mWebView;
        baseWebView2.setVisibility(0);
    }
}
