package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private h Nj;
    private int Nk;
    final /* synthetic */ a Nl;

    public d(a aVar, h hVar, int i) {
        this.Nl = aVar;
        this.Nj = null;
        this.Nk = -1;
        this.Nj = hVar;
        this.Nk = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.Nl.Ng;
            cVar2.aj(true);
            cVar3 = this.Nl.Ng;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.Nl.Ng;
        cVar.aj(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.Nl.Ng;
        cVar.pP();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.Nl.Ng;
        cVar.pO();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.Nl.Ng;
        cVar.pQ();
    }
}
