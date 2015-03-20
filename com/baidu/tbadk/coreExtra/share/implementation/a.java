package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate ady;
    private c adz;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.ady = null;
        this.mContext = context;
        this.ady = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.ady == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.adz = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.ady == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.ady.shareToWexinTimeline(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            case 3:
                this.ady.shareToWeixinFriend(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            case 4:
                this.ady.shareToQZone(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            case 5:
                this.ady.shareToQQWeibo(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            case 6:
                this.ady.shareToSinaWeibo(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            case 7:
                this.ady.shareToRenren(fVar.title, fVar.content, fVar.adm, fVar.adn, fVar.ado, this.mContext, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
