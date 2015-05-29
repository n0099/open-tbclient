package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private g aeO;
    private int aeP;
    final /* synthetic */ a aeQ;

    public d(a aVar, g gVar, int i) {
        this.aeQ = aVar;
        this.aeO = null;
        this.aeP = -1;
        this.aeO = gVar;
        this.aeP = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.aeQ.aeL;
            cVar2.aL(true);
            cVar3 = this.aeQ.aeL;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.aeQ.aeL;
        cVar.aL(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.aeQ.aeL;
        cVar.xG();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.aeQ.aeL;
        cVar.xF();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.aeQ.aeL;
        cVar.xH();
    }
}
