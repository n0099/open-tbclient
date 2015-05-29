package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate aeK;
    private c aeL;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.aeK = null;
        this.mContext = context;
        this.aeK = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.aeK == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.aeL = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(g gVar, int i, boolean z) {
        if (this.aeK == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.aeK.shareToWexinTimeline(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            case 3:
                this.aeK.shareToWeixinFriend(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            case 4:
                this.aeK.shareToQZone(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            case 5:
                this.aeK.shareToQQWeibo(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            case 6:
                this.aeK.shareToSinaWeibo(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            case 7:
                this.aeK.shareToRenren(gVar.title, gVar.content, gVar.linkUrl, gVar.imageUri, gVar.location, this.mContext, z, new d(this, gVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
