package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate asv;
    private b asw;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0036a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.asv = null;
        this.mContext = context;
        this.asv = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.asv != null) {
            this.asw = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        String str;
        if (this.asv != null && hVar != null) {
            switch (i) {
                case 2:
                    this.asv.shareToWexinTimeline(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 3:
                    this.asv.shareToWeixinFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 4:
                    this.asv.shareToQZone(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 5:
                    this.asv.shareToQQWeibo(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(hVar.asj)) {
                        str = hVar.asj;
                    } else {
                        str = hVar.linkUrl;
                    }
                    this.asv.shareToSinaWeibo(hVar.title, hVar.content, str, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 7:
                    this.asv.shareToRenren(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 8:
                    this.asv.shareToQQFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private int asA;
        private h asz;

        public c(h hVar, int i) {
            this.asz = null;
            this.asA = -1;
            this.asz = hVar;
            this.asA = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.asw.bl(true);
                a.this.asw.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.asw.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.asw.Bk();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.asw.Bj();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.asw.Bl();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a asb;
        private boolean asx = true;
        private InterfaceC0036a asy;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.asb = aVar;
        }

        public void bl(boolean z) {
            this.asx = z;
        }

        public void a(InterfaceC0036a interfaceC0036a) {
            this.asy = interfaceC0036a;
        }

        public void Bj() {
            if (this.asx) {
                this.asb.Ba();
                this.asy.onSuccess();
                return;
            }
            this.asb.Bc();
        }

        public void Bk() {
            this.asb.Bb();
        }

        public void Bl() {
            if (this.asx) {
                this.asb.Bd();
            } else {
                this.asb.Bd();
            }
        }
    }
}
