package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class az implements a.b {
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aJB;
    private final /* synthetic */ TbPageContext axK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.axK = tbPageContext;
        this.aJB = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iN()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.axK.getPageActivity(), this.aJB)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.axK.getPageActivity(), i.h.neterror);
        }
        aVar.dismiss();
    }
}
