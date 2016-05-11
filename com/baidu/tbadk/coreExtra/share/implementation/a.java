package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate aiY;
    private b aiZ;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.aiY = null;
        this.mContext = context;
        this.aiY = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.aiY != null) {
            this.aiZ = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.aiY != null) {
            switch (i) {
                case 2:
                    this.aiY.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.aiY.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.aiY.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.aiY.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.aiY.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.aiY.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f ajc;
        private int ajd;

        public c(f fVar, int i) {
            this.ajc = null;
            this.ajd = -1;
            this.ajc = fVar;
            this.ajd = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.aiZ.bf(true);
                a.this.aiZ.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.aiZ.bf(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.aiZ.zg();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.aiZ.zf();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.aiZ.zh();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a aiF;
        private boolean aja = true;
        private InterfaceC0037a ajb;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.aiF = aVar;
        }

        public void bf(boolean z) {
            this.aja = z;
        }

        public void a(InterfaceC0037a interfaceC0037a) {
            this.ajb = interfaceC0037a;
        }

        public void zf() {
            if (this.aja) {
                this.aiF.yX();
                this.ajb.onSuccess();
                return;
            }
            this.aiF.yZ();
        }

        public void zg() {
            this.aiF.yY();
        }

        public void zh() {
            if (this.aja) {
                this.aiF.za();
            } else {
                this.aiF.za();
            }
        }
    }
}
