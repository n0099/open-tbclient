package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate SV;
    private c SW;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.SV = null;
        this.mContext = context;
        this.SV = (BdSocialShareSdkDelegate) PluginCenter.gX().ha();
        if (this.SV == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.SW = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.SV == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.SV.shareToWexinTimeline(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            case 3:
                this.SV.shareToWeixinFriend(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            case 4:
                this.SV.shareToQZone(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            case 5:
                this.SV.shareToQQWeibo(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            case 6:
                this.SV.shareToSinaWeibo(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            case 7:
                this.SV.shareToRenren(fVar.title, fVar.content, fVar.SJ, fVar.SL, fVar.SM, this.mContext, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
