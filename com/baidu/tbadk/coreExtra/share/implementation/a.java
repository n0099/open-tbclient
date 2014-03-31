package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import android.util.Log;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tbplugin.k;
/* loaded from: classes.dex */
public final class a implements com.baidu.tbadk.coreExtra.share.b {
    private Context a;
    private BdSocialShareSdkDelegate b;
    private c c;

    public a(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = (BdSocialShareSdkDelegate) k.a().a(BdSocialShareSdkDelegate.class);
        if (this.b == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
        } else {
            this.c = new c(aVar);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.share.b
    public final void a(f fVar, int i, boolean z) {
        if (this.b == null) {
            Log.e("ShareTool", "Social Share Plugin Invalid");
            return;
        }
        switch (i) {
            case 2:
                this.b.shareToWexinTimeline(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            case 3:
                this.b.shareToWeixinFriend(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            case 4:
                this.b.shareToQZone(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            case 5:
                this.b.shareToQQWeibo(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            case 6:
                this.b.shareToSinaWeibo(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            case 7:
                this.b.shareToRenren(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e, this.a, z, new d(this, fVar, i));
                return;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
    }
}
