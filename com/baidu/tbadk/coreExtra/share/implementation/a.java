package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate aue;
    private b auf;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.aue = null;
        this.mContext = context;
        this.aue = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.aue != null) {
            this.auf = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(e eVar, int i, boolean z) {
        String str;
        if (this.aue != null && eVar != null) {
            switch (i) {
                case 2:
                    this.aue.shareToWexinTimeline(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 3:
                    this.aue.shareToWeixinFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 4:
                    this.aue.shareToQZone(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 5:
                    this.aue.shareToQQWeibo(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(eVar.atQ)) {
                        str = eVar.atQ;
                    } else {
                        str = eVar.linkUrl;
                    }
                    this.aue.shareToSinaWeibo(eVar.title, eVar.content, str, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 7:
                    this.aue.shareToRenren(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                case 8:
                    this.aue.shareToQQFriend(eVar.title, eVar.content, eVar.linkUrl, eVar.imageUri, eVar.location, this.mContext, z, new c(eVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private e aui;
        private int auj;

        public c(e eVar, int i) {
            this.aui = null;
            this.auj = -1;
            this.aui = eVar;
            this.auj = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.auf.bl(true);
                a.this.auf.a(new InterfaceC0048a() { // from class: com.baidu.tbadk.coreExtra.share.implementation.a.c.1
                    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0048a
                    public void onSuccess() {
                        a.this.a(c.this.aui, c.this.auj, false);
                    }
                });
                return;
            }
            a.this.auf.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.auf.AU();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.auf.AT();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.auf.AV();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a atG;
        private boolean aug = true;
        private InterfaceC0048a auh;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.atG = aVar;
        }

        public void bl(boolean z) {
            this.aug = z;
        }

        public void a(InterfaceC0048a interfaceC0048a) {
            this.auh = interfaceC0048a;
        }

        public void AT() {
            if (this.aug) {
                this.atG.AK();
                this.auh.onSuccess();
                return;
            }
            this.atG.AM();
        }

        public void AU() {
            this.atG.AL();
        }

        public void AV() {
            if (this.aug) {
                this.atG.AN();
            } else {
                this.atG.AN();
            }
        }
    }
}
