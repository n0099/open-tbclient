package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ajE;
    private b ajF;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ajE = null;
        this.mContext = context;
        this.ajE = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ajE != null) {
            this.ajF = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.ajE != null) {
            switch (i) {
                case 2:
                    this.ajE.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.ajE.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.ajE.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.ajE.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.ajE.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.ajE.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f ajI;
        private int ajJ;

        public c(f fVar, int i) {
            this.ajI = null;
            this.ajJ = -1;
            this.ajI = fVar;
            this.ajJ = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.ajF.bc(true);
                a.this.ajF.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.ajF.bc(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.ajF.zm();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.ajF.zl();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.ajF.zn();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private boolean ajG = true;
        private InterfaceC0037a ajH;
        private com.baidu.tbadk.coreExtra.share.a ajl;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.ajl = aVar;
        }

        public void bc(boolean z) {
            this.ajG = z;
        }

        public void a(InterfaceC0037a interfaceC0037a) {
            this.ajH = interfaceC0037a;
        }

        public void zl() {
            if (this.ajG) {
                this.ajl.zd();
                this.ajH.onSuccess();
                return;
            }
            this.ajl.zf();
        }

        public void zm() {
            this.ajl.ze();
        }

        public void zn() {
            if (this.ajG) {
                this.ajl.zg();
            } else {
                this.ajl.zg();
            }
        }
    }
}
