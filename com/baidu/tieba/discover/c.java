package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aOb;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aOb = aVar;
        this.aOc = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jg()) {
            PluginPackageManager.lU().a(this.aOc, (com.baidu.adp.plugin.packageManager.e) null);
        } else {
            this.aOb.showToast(n.i.neterror);
        }
        aVar.dismiss();
    }
}
