package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate asd;
    private b ase;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.asd = null;
        this.mContext = context;
        this.asd = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.asd != null) {
            this.ase = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(g gVar, int i, boolean z) {
        String str;
        if (this.asd != null && gVar != null) {
            switch (i) {
                case 2:
                    this.asd.shareToWexinTimeline(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 3:
                    this.asd.shareToWeixinFriend(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 4:
                    this.asd.shareToQZone(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 5:
                    this.asd.shareToQQWeibo(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(gVar.arR)) {
                        str = gVar.arR;
                    } else {
                        str = gVar.linkUrl;
                    }
                    this.asd.shareToSinaWeibo(gVar.title, gVar.content, str, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 7:
                    this.asd.shareToRenren(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 8:
                    this.asd.shareToQQFriend(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private g ash;
        private int asi;

        public c(g gVar, int i) {
            this.ash = null;
            this.asi = -1;
            this.ash = gVar;
            this.asi = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.ase.bj(true);
                a.this.ase.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.ase.bj(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.ase.AL();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.ase.AK();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.ase.AM();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a arJ;
        private boolean asf = true;
        private InterfaceC0037a asg;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.arJ = aVar;
        }

        public void bj(boolean z) {
            this.asf = z;
        }

        public void a(InterfaceC0037a interfaceC0037a) {
            this.asg = interfaceC0037a;
        }

        public void AK() {
            if (this.asf) {
                this.arJ.AB();
                this.asg.onSuccess();
                return;
            }
            this.arJ.AD();
        }

        public void AL() {
            this.arJ.AC();
        }

        public void AM() {
            if (this.asf) {
                this.arJ.AE();
            } else {
                this.arJ.AE();
            }
        }
    }
}
