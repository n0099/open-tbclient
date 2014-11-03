package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private h Nn;
    private int No;
    final /* synthetic */ a Np;

    public d(a aVar, h hVar, int i) {
        this.Np = aVar;
        this.Nn = null;
        this.No = -1;
        this.Nn = hVar;
        this.No = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.Np.Nk;
            cVar2.aj(true);
            cVar3 = this.Np.Nk;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.Np.Nk;
        cVar.aj(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.Np.Nk;
        cVar.pR();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.Np.Nk;
        cVar.pQ();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.Np.Nk;
        cVar.pS();
    }
}
