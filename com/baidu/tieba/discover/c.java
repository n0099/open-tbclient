package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aLq;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aLr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aLq = aVar;
        this.aLr = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jf()) {
            PluginPackageManager.lT().a(this.aLr, (com.baidu.adp.plugin.packageManager.d) null);
        } else {
            this.aLq.showToast(i.C0057i.neterror);
        }
        aVar.dismiss();
    }
}
