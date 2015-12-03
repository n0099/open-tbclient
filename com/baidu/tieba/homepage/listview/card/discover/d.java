package com.baidu.tieba.homepage.listview.card.discover;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements a.b {
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aOc;
    private final /* synthetic */ TbPageContext azR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginNetConfigInfos.PluginConfig pluginConfig, TbPageContext tbPageContext) {
        this.aOc = pluginConfig;
        this.azR = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jg()) {
            PluginPackageManager.lU().a(this.aOc, (com.baidu.adp.plugin.packageManager.e) null);
        } else {
            this.azR.showToast(n.i.neterror);
        }
        aVar.dismiss();
    }
}
