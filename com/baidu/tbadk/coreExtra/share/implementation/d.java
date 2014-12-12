package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    private f SZ;
    private int Ta;
    final /* synthetic */ a Tb;

    public d(a aVar, f fVar, int i) {
        this.Tb = aVar;
        this.SZ = null;
        this.Ta = -1;
        this.SZ = fVar;
        this.Ta = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.Tb.SW;
            cVar2.ax(true);
            cVar3 = this.Tb.SW;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.Tb.SW;
        cVar.ax(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.Tb.SW;
        cVar.tk();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.Tb.SW;
        cVar.tj();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.Tb.SW;
        cVar.tl();
    }
}
