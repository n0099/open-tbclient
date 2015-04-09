package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private f adK;
    private int adL;
    final /* synthetic */ a adM;

    public d(a aVar, f fVar, int i) {
        this.adM = aVar;
        this.adK = null;
        this.adL = -1;
        this.adK = fVar;
        this.adL = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.adM.adH;
            cVar2.aE(true);
            cVar3 = this.adM.adH;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.adM.adH;
        cVar.aE(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.adM.adH;
        cVar.wU();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.adM.adH;
        cVar.wT();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.adM.adH;
        cVar.wV();
    }
}
