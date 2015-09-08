package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aLD;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aLD = aVar;
        this.aLE = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jc()) {
            PluginPackageManager.lQ().a(this.aLE, (com.baidu.adp.plugin.packageManager.d) null);
        } else {
            this.aLD.showToast(i.h.neterror);
        }
        aVar.dismiss();
    }
}
