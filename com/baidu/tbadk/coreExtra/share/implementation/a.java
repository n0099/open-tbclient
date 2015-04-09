package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate adG;
    private c adH;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.adG = null;
        this.mContext = context;
        this.adG = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.adG == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.adH = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.adG == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.adG.shareToWexinTimeline(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            case 3:
                this.adG.shareToWeixinFriend(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            case 4:
                this.adG.shareToQZone(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            case 5:
                this.adG.shareToQQWeibo(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            case 6:
                this.adG.shareToSinaWeibo(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            case 7:
                this.adG.shareToRenren(fVar.title, fVar.content, fVar.adu, fVar.adv, fVar.adw, this.mContext, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
