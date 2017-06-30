package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate atm;
    private b atn;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.atm = null;
        this.mContext = context;
        this.atm = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.atm != null) {
            this.atn = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        String str;
        if (this.atm != null && hVar != null) {
            switch (i) {
                case 2:
                    this.atm.shareToWexinTimeline(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 3:
                    this.atm.shareToWeixinFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 4:
                    this.atm.shareToQZone(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 5:
                    this.atm.shareToQQWeibo(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(hVar.asY)) {
                        str = hVar.asY;
                    } else {
                        str = hVar.linkUrl;
                    }
                    this.atm.shareToSinaWeibo(hVar.title, hVar.content, str, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 7:
                    this.atm.shareToRenren(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 8:
                    this.atm.shareToQQFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private h atq;
        private int atr;

        public c(h hVar, int i) {
            this.atq = null;
            this.atr = -1;
            this.atq = hVar;
            this.atr = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.atn.bj(true);
                a.this.atn.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.atn.bj(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.atn.AJ();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.atn.AI();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.atn.AK();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a asP;
        private boolean ato = true;
        private InterfaceC0042a atp;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.asP = aVar;
        }

        public void bj(boolean z) {
            this.ato = z;
        }

        public void a(InterfaceC0042a interfaceC0042a) {
            this.atp = interfaceC0042a;
        }

        public void AI() {
            if (this.ato) {
                this.asP.Az();
                this.atp.onSuccess();
                return;
            }
            this.asP.AB();
        }

        public void AJ() {
            this.asP.AA();
        }

        public void AK() {
            if (this.ato) {
                this.asP.AC();
            } else {
                this.asP.AC();
            }
        }
    }
}
