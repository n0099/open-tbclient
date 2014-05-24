package com.baidu.tbadk.plugins;

import android.content.Context;
import com.baidu.tbadk.tbplugin.h;
/* loaded from: classes.dex */
public class a {
    public void a(Context context, boolean z, boolean z2, h hVar) {
        if (z) {
            new com.baidu.tbadk.tbplugin.a(context, BdSocialShareSdkDelegate.class, z2, new b(this)).a();
            new com.baidu.tbadk.tbplugin.a(context, DQSdkPlugin.class, z2, new c(this)).a();
            new com.baidu.tbadk.tbplugin.a(context, Hao123Plugin.class, z2, new d(this)).a();
            new com.baidu.tbadk.tbplugin.a(context, BatSdkDelegate.class, z2, new e(this, hVar)).a();
            if (!z2 && hVar != null) {
                hVar.a();
                return;
            }
            return;
        }
        new com.baidu.tbadk.tbplugin.a(context, BdSocialShareSdkDelegate.class).a();
        new com.baidu.tbadk.tbplugin.a(context, DQSdkPlugin.class).a();
        new com.baidu.tbadk.tbplugin.a(context, Hao123Plugin.class, z2).a();
        new com.baidu.tbadk.tbplugin.a(context, BatSdkDelegate.class).a();
        if (hVar != null) {
            hVar.a();
        }
    }
}
