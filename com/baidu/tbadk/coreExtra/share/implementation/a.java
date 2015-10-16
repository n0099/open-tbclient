package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ajb;
    private b ajc;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ajb = null;
        this.mContext = context;
        this.ajb = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ajb != null) {
            this.ajc = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.ajb != null) {
            switch (i) {
                case 2:
                    this.ajb.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.ajb.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.ajb.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.ajb.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.ajb.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.ajb.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f ajf;
        private int ajg;

        public c(f fVar, int i) {
            this.ajf = null;
            this.ajg = -1;
            this.ajf = fVar;
            this.ajg = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.ajc.aP(true);
                a.this.ajc.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.ajc.aP(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.ajc.yH();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.ajc.yG();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.ajc.yI();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a aiK;
        private boolean ajd = true;
        private InterfaceC0043a aje;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.aiK = aVar;
        }

        public void aP(boolean z) {
            this.ajd = z;
        }

        public void a(InterfaceC0043a interfaceC0043a) {
            this.aje = interfaceC0043a;
        }

        public void yG() {
            if (this.ajd) {
                this.aiK.yz();
                this.aje.onSuccess();
                return;
            }
            this.aiK.yB();
        }

        public void yH() {
            this.aiK.yA();
        }

        public void yI() {
            if (this.ajd) {
                this.aiK.yC();
            } else {
                this.aiK.yC();
            }
        }
    }
}
