package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private f TA;
    private int TB;
    final /* synthetic */ a TC;

    public d(a aVar, f fVar, int i) {
        this.TC = aVar;
        this.TA = null;
        this.TB = -1;
        this.TA = fVar;
        this.TB = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.TC.Tx;
            cVar2.az(true);
            cVar3 = this.TC.Tx;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.TC.Tx;
        cVar.az(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.TC.Tx;
        cVar.tv();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.TC.Tx;
        cVar.tu();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.TC.Tx;
        cVar.tw();
    }
}
