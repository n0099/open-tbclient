package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aJA;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aJA = aVar;
        this.aJB = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.je()) {
            PluginPackageManager.lS().a(this.aJB, (com.baidu.adp.plugin.packageManager.d) null);
        } else {
            this.aJA.showToast(i.h.neterror);
        }
        aVar.dismiss();
    }
}
