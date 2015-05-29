package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aDS;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aDS = aVar;
        this.aDT = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            PluginPackageManager.lM().a(this.aDT, (com.baidu.adp.plugin.packageManager.i) null);
        } else {
            this.aDS.showToast(com.baidu.tieba.t.neterror);
        }
        aVar.dismiss();
    }
}
