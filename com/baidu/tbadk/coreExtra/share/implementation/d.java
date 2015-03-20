package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private f adC;
    private int adD;
    final /* synthetic */ a adE;

    public d(a aVar, f fVar, int i) {
        this.adE = aVar;
        this.adC = null;
        this.adD = -1;
        this.adC = fVar;
        this.adD = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.adE.adz;
            cVar2.aE(true);
            cVar3 = this.adE.adz;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.adE.adz;
        cVar.aE(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.adE.adz;
        cVar.wO();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.adE.adz;
        cVar.wN();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.adE.adz;
        cVar.wP();
    }
}
