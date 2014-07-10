package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BdSocialShareSdkDelegate.ShareCallback {
    final /* synthetic */ a a;
    private h b;
    private int c;

    public d(a aVar, h hVar, int i) {
        this.a = aVar;
        this.b = null;
        this.c = -1;
        this.b = hVar;
        this.c = i;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void shareCallback(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        if (z) {
            cVar2 = this.a.c;
            cVar2.a(true);
            cVar3 = this.a.c;
            cVar3.a(new e(this));
            return;
        }
        cVar = this.a.c;
        cVar.a(false);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCancelOfBaiduListener() {
        c cVar;
        cVar = this.a.c;
        cVar.b();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onCompleteOfBaiduListener() {
        c cVar;
        cVar = this.a.c;
        cVar.a();
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
    public void onErrorOfBaiduListener() {
        c cVar;
        cVar = this.a.c;
        cVar.c();
    }
}
