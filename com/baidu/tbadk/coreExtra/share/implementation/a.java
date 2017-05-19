package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private b asA;
    private BdSocialShareSdkDelegate asz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.asz = null;
        this.mContext = context;
        this.asz = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.asz != null) {
            this.asA = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        String str;
        if (this.asz != null && hVar != null) {
            switch (i) {
                case 2:
                    this.asz.shareToWexinTimeline(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 3:
                    this.asz.shareToWeixinFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 4:
                    this.asz.shareToQZone(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 5:
                    this.asz.shareToQQWeibo(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(hVar.asl)) {
                        str = hVar.asl;
                    } else {
                        str = hVar.linkUrl;
                    }
                    this.asz.shareToSinaWeibo(hVar.title, hVar.content, str, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 7:
                    this.asz.shareToRenren(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                case 8:
                    this.asz.shareToQQFriend(hVar.title, hVar.content, hVar.linkUrl, hVar.imageUri, hVar.location, this.mContext, z, new c(hVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private h asD;
        private int asE;

        public c(h hVar, int i) {
            this.asD = null;
            this.asE = -1;
            this.asD = hVar;
            this.asE = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.asA.bl(true);
                a.this.asA.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.asA.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.asA.Av();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.asA.Au();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.asA.Aw();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private boolean asB = true;
        private InterfaceC0040a asC;
        private com.baidu.tbadk.coreExtra.share.a asd;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.asd = aVar;
        }

        public void bl(boolean z) {
            this.asB = z;
        }

        public void a(InterfaceC0040a interfaceC0040a) {
            this.asC = interfaceC0040a;
        }

        public void Au() {
            if (this.asB) {
                this.asd.Al();
                this.asC.onSuccess();
                return;
            }
            this.asd.An();
        }

        public void Av() {
            this.asd.Am();
        }

        public void Aw() {
            if (this.asB) {
                this.asd.Ao();
            } else {
                this.asd.Ao();
            }
        }
    }
}
