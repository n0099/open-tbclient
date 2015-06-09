package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aDT;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aDT = aVar;
        this.aDU = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            PluginPackageManager.lM().a(this.aDU, (com.baidu.adp.plugin.packageManager.i) null);
        } else {
            this.aDT.showToast(com.baidu.tieba.t.neterror);
        }
        aVar.dismiss();
    }
}
