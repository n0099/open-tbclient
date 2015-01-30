package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private f TD;
    private int TE;
    final /* synthetic */ a TF;

    public d(a aVar, f fVar, int i) {
        this.TF = aVar;
        this.TD = null;
        this.TE = -1;
        this.TD = fVar;
        this.TE = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.TF.TA;
            cVar2.az(true);
            cVar3 = this.TF.TA;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.TF.TA;
        cVar.az(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.TF.TA;
        cVar.tB();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.TF.TA;
        cVar.tA();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.TF.TA;
        cVar.tC();
    }
}
