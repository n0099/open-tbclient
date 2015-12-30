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
class bb implements a.b {
    private final /* synthetic */ TbPageContext aBy;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aBy = tbPageContext;
        this.aRU = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iQ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.aBy.getPageActivity(), this.aRU)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aBy.getPageActivity(), n.j.neterror);
        }
        aVar.dismiss();
    }
}
