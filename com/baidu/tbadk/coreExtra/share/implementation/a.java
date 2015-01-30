package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private c TA;
    private BdSocialShareSdkDelegate Tz;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.Tz = null;
        this.mContext = context;
        this.Tz = (BdSocialShareSdkDelegate) PluginCenter.gW().gZ();
        if (this.Tz == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.TA = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(f fVar, int i, boolean z) {
        if (this.Tz == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.Tz.shareToWexinTimeline(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            case 3:
                this.Tz.shareToWeixinFriend(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            case 4:
                this.Tz.shareToQZone(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            case 5:
                this.Tz.shareToQQWeibo(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            case 6:
                this.Tz.shareToSinaWeibo(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            case 7:
                this.Tz.shareToRenren(fVar.title, fVar.content, fVar.Tq, fVar.Tr, fVar.Ts, this.mContext, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
