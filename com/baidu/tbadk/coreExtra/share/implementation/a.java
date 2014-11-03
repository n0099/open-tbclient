package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private BdSocialShareSdkDelegate Nj;
    private c Nk;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.mContext = null;
        this.Nj = null;
        this.mContext = context;
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_SOCIAL_SHARE);
        if (pluginByName != null) {
            this.Nj = (BdSocialShareSdkDelegate) pluginByName.getClassInstance(BdSocialShareSdkDelegate.class);
        }
        if (this.Nj == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.Nk = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        if (this.Nj == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.Nj.shareToWexinTimeline(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            case 3:
                this.Nj.shareToWeixinFriend(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            case 4:
                this.Nj.shareToQZone(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            case 5:
                this.Nj.shareToQQWeibo(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            case 6:
                this.Nj.shareToSinaWeibo(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            case 7:
                this.Nj.shareToRenren(hVar.title, hVar.content, hVar.Na, hVar.Nb, hVar.Nc, this.mContext, z, new d(this, hVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
