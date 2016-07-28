package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate akt;
    private b aku;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.akt = null;
        this.mContext = context;
        this.akt = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.akt != null) {
            this.aku = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.akt != null) {
            switch (i) {
                case 2:
                    this.akt.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.akt.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.akt.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.akt.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.akt.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.akt.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f akx;
        private int aky;

        public c(f fVar, int i) {
            this.akx = null;
            this.aky = -1;
            this.akx = fVar;
            this.aky = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.aku.bf(true);
                a.this.aku.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.aku.bf(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.aku.zm();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.aku.zl();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.aku.zn();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a aka;
        private boolean akv = true;
        private InterfaceC0038a akw;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.aka = aVar;
        }

        public void bf(boolean z) {
            this.akv = z;
        }

        public void a(InterfaceC0038a interfaceC0038a) {
            this.akw = interfaceC0038a;
        }

        public void zl() {
            if (this.akv) {
                this.aka.zd();
                this.akw.onSuccess();
                return;
            }
            this.aka.zf();
        }

        public void zm() {
            this.aka.ze();
        }

        public void zn() {
            if (this.akv) {
                this.aka.zg();
            } else {
                this.aka.zg();
            }
        }
    }
}
