package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class ay implements a.b {
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aOc;
    private final /* synthetic */ TbPageContext azR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.azR = tbPageContext;
        this.aOc = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iP()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.azR.getPageActivity(), this.aOc)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.azR.getPageActivity(), n.i.neterror);
        }
        aVar.dismiss();
    }
}
