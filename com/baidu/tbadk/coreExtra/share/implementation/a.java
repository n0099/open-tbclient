package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ast;
    private b asu;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.share.implementation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0036a {
        void onSuccess();
    }

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ast = null;
        this.mContext = context;
        this.ast = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ast != null) {
            this.asu = new b(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(g gVar, int i, boolean z) {
        String str;
        if (this.ast != null && gVar != null) {
            switch (i) {
                case 2:
                    this.ast.shareToWexinTimeline(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 3:
                    this.ast.shareToWeixinFriend(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 4:
                    this.ast.shareToQZone(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 5:
                    this.ast.shareToQQWeibo(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 6:
                    if (!StringUtils.isNull(gVar.ash)) {
                        str = gVar.ash;
                    } else {
                        str = gVar.linkUrl;
                    }
                    this.ast.shareToSinaWeibo(gVar.title, gVar.content, str, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 7:
                    this.ast.shareToRenren(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                case 8:
                    this.ast.shareToQQFriend(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new c(gVar, i));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements BdSocialShareSdkDelegate.ShareCallback {
        private g asx;
        private int asy;

        public c(g gVar, int i) {
            this.asx = null;
            this.asy = -1;
            this.asx = gVar;
            this.asy = i;
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void shareCallback(boolean z) {
            if (z) {
                a.this.asu.bl(true);
                a.this.asu.a(new com.baidu.tbadk.coreExtra.share.implementation.b(this));
                return;
            }
            a.this.asu.bl(false);
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCancelOfBaiduListener() {
            a.this.asu.Bk();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onCompleteOfBaiduListener() {
            a.this.asu.Bj();
        }

        @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate.ShareCallback
        public void onErrorOfBaiduListener() {
            a.this.asu.Bl();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private com.baidu.tbadk.coreExtra.share.a arZ;
        private boolean asv = true;
        private InterfaceC0036a asw;

        public b(com.baidu.tbadk.coreExtra.share.a aVar) {
            this.arZ = aVar;
        }

        public void bl(boolean z) {
            this.asv = z;
        }

        public void a(InterfaceC0036a interfaceC0036a) {
            this.asw = interfaceC0036a;
        }

        public void Bj() {
            if (this.asv) {
                this.arZ.Ba();
                this.asw.onSuccess();
                return;
            }
            this.arZ.Bc();
        }

        public void Bk() {
            this.arZ.Bb();
        }

        public void Bl() {
            if (this.asv) {
                this.arZ.Bd();
            } else {
                this.arZ.Bd();
            }
        }
    }
}
