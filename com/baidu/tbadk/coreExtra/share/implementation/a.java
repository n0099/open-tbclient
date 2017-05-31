package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate asj;
    private b ask;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.asj = null;
        this.mContext = context;
        this.asj = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.asj != null) {
            this.ask = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        String str;
        if (this.asj != null && hVar != null) {
            switch (i) {
                case 2:
                    this.asj.shareToWexinTimeline(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 3:
                    this.asj.shareToWeixinFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 4:
                    this.asj.shareToQZone(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 5:
                    this.asj.shareToQQWeibo(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(hVar.arV)) {
                        str = hVar.arV;
                    } else {
                        str = hVar.linkUrl;
                    }
                    this.asj.shareToSinaWeibo(hVar.title, hVar.content, str, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 7:
                    this.asj.shareToRenren(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 8:
                    this.asj.shareToQQFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private h asn;
        private int aso;

        public c(h hVar, int i) {
            this.asn = null;
            this.aso = -1;
            this.asn = hVar;
            this.aso = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.ask.bi(true);
                a.this.ask.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.ask.bi(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.ask.Ao();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.ask.An();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.ask.Ap();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a arN;
        private boolean asl = true;
        private InterfaceC0040a asm;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.arN = aVar;
        }

        public void bi(boolean z) {
            this.asl = z;
        }

        public void a(InterfaceC0040a interfaceC0040a) {
            this.asm = interfaceC0040a;
        }

        public void An() {
            if (this.asl) {
                this.arN.Ae();
                this.asm.onSuccess();
                return;
            }
            this.arN.Ag();
        }

        public void Ao() {
            this.arN.Af();
        }

        public void Ap() {
            if (this.asl) {
                this.arN.Ah();
            } else {
                this.arN.Ah();
            }
        }
    }
}
