package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate avx;
    private b avy;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.avx = null;
        this.mContext = context;
        this.avx = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.avx != null) {
            this.avy = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(e eVar, int i, boolean z) {
        String str;
        if (this.avx != null && eVar != null) {
            switch (i) {
                case 2:
                    this.avx.shareToWexinTimeline(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 3:
                    this.avx.shareToWeixinFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 4:
                    this.avx.shareToQZone(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 5:
                    this.avx.shareToQQWeibo(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(eVar.avj)) {
                        str = eVar.avj;
                    } else {
                        str = eVar.linkUrl;
                    }
                    this.avx.shareToSinaWeibo(eVar.title, eVar.content, str, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 7:
                    this.avx.shareToRenren(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 8:
                    this.avx.shareToQQFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private e avB;
        private int avC;

        public c(e eVar, int i) {
            this.avB = null;
            this.avC = -1;
            this.avB = eVar;
            this.avC = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.avy.bl(true);
                a.this.avy.a(new InterfaceC0048a() { // from class: com.baidu.tbadk.coreExtra.share.implementation.a.c.1
                    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0048a
                    public void onSuccess() {
                        a.this.a(c.this.avB, c.this.avC, false);
                    }
                });
                return;
            }
            a.this.avy.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.avy.Bc();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.avy.Bb();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.avy.Bd();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a auZ;
        private InterfaceC0048a avA;
        private boolean avz = true;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.auZ = aVar;
        }

        public void bl(boolean z) {
            this.avz = z;
        }

        public void a(InterfaceC0048a interfaceC0048a) {
            this.avA = interfaceC0048a;
        }

        public void Bb() {
            if (this.avz) {
                this.auZ.AS();
                this.avA.onSuccess();
                return;
            }
            this.auZ.AU();
        }

        public void Bc() {
            this.auZ.AT();
        }

        public void Bd() {
            if (this.avz) {
                this.auZ.AV();
            } else {
                this.auZ.AV();
            }
        }
    }
}
