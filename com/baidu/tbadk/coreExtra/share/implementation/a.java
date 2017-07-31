package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate avv;
    private b avw;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.avv = null;
        this.mContext = context;
        this.avv = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.avv != null) {
            this.avw = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(e eVar, int i, boolean z) {
        String str;
        if (this.avv != null && eVar != null) {
            switch (i) {
                case 2:
                    this.avv.shareToWexinTimeline(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 3:
                    this.avv.shareToWeixinFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 4:
                    this.avv.shareToQZone(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 5:
                    this.avv.shareToQQWeibo(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(eVar.avh)) {
                        str = eVar.avh;
                    } else {
                        str = eVar.linkUrl;
                    }
                    this.avv.shareToSinaWeibo(eVar.title, eVar.content, str, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 7:
                    this.avv.shareToRenren(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 8:
                    this.avv.shareToQQFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private int avA;
        private e avz;

        public c(e eVar, int i) {
            this.avz = null;
            this.avA = -1;
            this.avz = eVar;
            this.avA = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.avw.bl(true);
                a.this.avw.a(new InterfaceC0048a() { // from class: com.baidu.tbadk.coreExtra.share.implementation.a.c.1
                    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0048a
                    public void onSuccess() {
                        a.this.a(c.this.avz, c.this.avA, false);
                    }
                });
                return;
            }
            a.this.avw.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.avw.Bc();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.avw.Bb();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.avw.Bd();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a auX;
        private boolean avx = true;
        private InterfaceC0048a avy;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.auX = aVar;
        }

        public void bl(boolean z) {
            this.avx = z;
        }

        public void a(InterfaceC0048a interfaceC0048a) {
            this.avy = interfaceC0048a;
        }

        public void Bb() {
            if (this.avx) {
                this.auX.AS();
                this.avy.onSuccess();
                return;
            }
            this.auX.AU();
        }

        public void Bc() {
            this.auX.AT();
        }

        public void Bd() {
            if (this.avx) {
                this.auX.AV();
            } else {
                this.auX.AV();
            }
        }
    }
}
