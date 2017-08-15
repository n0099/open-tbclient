package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate avw;
    private b avx;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.avw = null;
        this.mContext = context;
        this.avw = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.avw != null) {
            this.avx = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(e eVar, int i, boolean z) {
        String str;
        if (this.avw != null && eVar != null) {
            switch (i) {
                case 2:
                    this.avw.shareToWexinTimeline(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 3:
                    this.avw.shareToWeixinFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 4:
                    this.avw.shareToQZone(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 5:
                    this.avw.shareToQQWeibo(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(eVar.avi)) {
                        str = eVar.avi;
                    } else {
                        str = eVar.linkUrl;
                    }
                    this.avw.shareToSinaWeibo(eVar.title, eVar.content, str, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 7:
                    this.avw.shareToRenren(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 8:
                    this.avw.shareToQQFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private e avA;
        private int avB;

        public c(e eVar, int i) {
            this.avA = null;
            this.avB = -1;
            this.avA = eVar;
            this.avB = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.avx.bl(true);
                a.this.avx.a(new InterfaceC0048a() { // from class: com.baidu.tbadk.coreExtra.share.implementation.a.c.1
                    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0048a
                    public void onSuccess() {
                        a.this.a(c.this.avA, c.this.avB, false);
                    }
                });
                return;
            }
            a.this.avx.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.avx.Bc();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.avx.Bb();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.avx.Bd();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a auY;
        private boolean avy = true;
        private InterfaceC0048a avz;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.auY = aVar;
        }

        public void bl(boolean z) {
            this.avy = z;
        }

        public void a(InterfaceC0048a interfaceC0048a) {
            this.avz = interfaceC0048a;
        }

        public void Bb() {
            if (this.avy) {
                this.auY.AS();
                this.avz.onSuccess();
                return;
            }
            this.auY.AU();
        }

        public void Bc() {
            this.auY.AT();
        }

        public void Bd() {
            if (this.avy) {
                this.auY.AV();
            } else {
                this.auY.AV();
            }
        }
    }
}
