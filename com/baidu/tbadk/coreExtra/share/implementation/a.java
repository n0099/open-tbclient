package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tbadk.tbplugin.m;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.coreExtra.share.b {
    private Context a;
    private BdSocialShareSdkDelegate b;
    private c c;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = (BdSocialShareSdkDelegate) m.a().b(BdSocialShareSdkDelegate.class);
        if (this.b == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.c = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public void a(h hVar, int i, boolean z) {
        if (this.b == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.b.shareToWexinTimeline(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            case 3:
                this.b.shareToWeixinFriend(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            case 4:
                this.b.shareToQZone(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            case 5:
                this.b.shareToQQWeibo(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            case 6:
                this.b.shareToSinaWeibo(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            case 7:
                this.b.shareToRenren(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e, this.a, z, new d(this, hVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
