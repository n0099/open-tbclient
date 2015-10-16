package com.baidu.tieba.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ a aKG;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aKH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aKG = aVar;
        this.aKH = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jd()) {
            PluginPackageManager.lR().a(this.aKH, (com.baidu.adp.plugin.packageManager.d) null);
        } else {
            this.aKG.showToast(i.h.neterror);
        }
        aVar.dismiss();
    }
}
