package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ank;
    private b anl;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ank = null;
        this.mContext = context;
        this.ank = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ank != null) {
            this.anl = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.ank != null) {
            switch (i) {
                case 2:
                    this.ank.shareToWexinTimeline(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 3:
                    this.ank.shareToWeixinFriend(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 4:
                    this.ank.shareToQZone(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 5:
                    this.ank.shareToQQWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 6:
                    this.ank.shareToSinaWeibo(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                case 7:
                    this.ank.shareToRenren(fVar.title, fVar.content, fVar.linkUrl, fVar.imageUri, fVar.location, this.mContext, z, new c(fVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private f ano;
        private int anp;

        public c(f fVar, int i) {
            this.ano = null;
            this.anp = -1;
            this.ano = fVar;
            this.anp = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.anl.aZ(true);
                a.this.anl.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.anl.aZ(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.anl.Bm();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.anl.Bl();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.anl.Bn();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a amS;
        private boolean anm = true;
        private InterfaceC0046a ann;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.amS = aVar;
        }

        public void aZ(boolean z) {
            this.anm = z;
        }

        public void a(InterfaceC0046a interfaceC0046a) {
            this.ann = interfaceC0046a;
        }

        public void Bl() {
            if (this.anm) {
                this.amS.Be();
                this.ann.onSuccess();
                return;
            }
            this.amS.Bg();
        }

        public void Bm() {
            this.amS.Bf();
        }

        public void Bn() {
            if (this.anm) {
                this.amS.Bh();
            } else {
                this.amS.Bh();
            }
        }
    }
}
