package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate Tw;
    private c Tx;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.Tw = null;
        this.mContext = context;
        this.Tw = (BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance();
        if (this.Tw == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.Tx = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.Tw == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.Tw.shareToWexinTimeline(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            case 3:
                this.Tw.shareToWeixinFriend(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            case 4:
                this.Tw.shareToQZone(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            case 5:
                this.Tw.shareToQQWeibo(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            case 6:
                this.Tw.shareToSinaWeibo(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            case 7:
                this.Tw.shareToRenren(fVar.title, fVar.content, fVar.Tn, fVar.To, fVar.Tp, this.mContext, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
