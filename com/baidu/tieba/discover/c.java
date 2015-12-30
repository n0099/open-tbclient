package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aRT;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aRT = aVar;
        this.aRU = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jh()) {
            PluginPackageManager.ls().a(this.aRU, (com.baidu.adp.plugin.packageManager.e) null);
        } else {
            this.aRT.showToast(n.j.neterror);
        }
        aVar.dismiss();
    }
}
