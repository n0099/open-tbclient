package com.baidu.tbadk.plugins;

import android.content.Context;
import com.baidu.tbplugin.k;
/* loaded from: classes.dex */
public final class a {
    public final void a(Context context, boolean z, boolean z2, com.baidu.tbplugin.c cVar) {
        if (z) {
            new com.baidu.tbplugin.a(context, BdBrowserDelegate.class, z2, new b(this)).a();
            new com.baidu.tbplugin.a(context, BdSocialShareSdkDelegate.class, z2, new c(this)).a();
            new com.baidu.tbplugin.a(context, BatSdkDelegate.class, z2, new d(this)).a();
            new com.baidu.tbplugin.a(context, MotuPlugin.class, z2, new e(this)).a();
            new com.baidu.tbplugin.a(context, BdSapiCoreLightDelegate.class, z2, new f(this, cVar)).a();
            if (!z2 && cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        new com.baidu.tbplugin.a(context, BdBrowserDelegate.class, z2).a();
        new com.baidu.tbplugin.a(context, BdSapiCoreLightDelegate.class, z2).a();
        new com.baidu.tbplugin.a(context, BatSdkDelegate.class, z2).a();
        new com.baidu.tbplugin.a(context, MotuPlugin.class, z2).a();
        new com.baidu.tbplugin.a(context, BdSocialShareSdkDelegate.class, z2).a();
        k.a();
        k.a("com.baidu.tbadk.plugins.BdBrowserDelegate");
        k.a();
        k.a("com.baidu.tbadk.plugins.BdSapiCoreLightDelegate");
        k.a();
        k.a("com.baidu.tbadk.plugins.BatSdkDelegate");
        k.a();
        k.a("com.baidu.tbadk.plugins.BdSocialShareSdkDelegate");
        k.a();
        k.a("com.baidu.tbadk.plugins.MotuPlugin");
        k.a().h();
        if (cVar != null) {
            cVar.a();
        }
    }
}
