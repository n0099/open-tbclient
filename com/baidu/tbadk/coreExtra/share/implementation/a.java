package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ajg;
    private b ajh;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ajg = null;
        this.mContext = context;
        this.ajg = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ajg != null) {
            this.ajh = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.ajg != null) {
            switch (i) {
                case 2:
                    this.ajg.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.ajg.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.ajg.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.ajg.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.ajg.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.ajg.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f ajk;
        private int ajl;

        public c(f fVar, int i) {
            this.ajk = null;
            this.ajl = -1;
            this.ajk = fVar;
            this.ajl = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.ajh.aP(true);
                a.this.ajh.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.ajh.aP(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.ajh.yJ();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.ajh.yI();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.ajh.yK();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a aiP;
        private boolean aji = true;
        private InterfaceC0043a ajj;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.aiP = aVar;
        }

        public void aP(boolean z) {
            this.aji = z;
        }

        public void a(InterfaceC0043a interfaceC0043a) {
            this.ajj = interfaceC0043a;
        }

        public void yI() {
            if (this.aji) {
                this.aiP.yB();
                this.ajj.onSuccess();
                return;
            }
            this.aiP.yD();
        }

        public void yJ() {
            this.aiP.yC();
        }

        public void yK() {
            if (this.aji) {
                this.aiP.yE();
            } else {
                this.aiP.yE();
            }
        }
    }
}
