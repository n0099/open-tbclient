package com.baidu.tbadk.vcode;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        baseWebView = this.aEz.mWebView;
        if (baseWebView == null) {
            return;
        }
        this.aEz.HJ();
        baseWebView2 = this.aEz.mWebView;
        baseWebView2.setVisibility(0);
    }
}
