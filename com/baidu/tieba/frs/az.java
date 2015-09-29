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
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aKw;
    private final /* synthetic */ TbPageContext ayK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.ayK = tbPageContext;
        this.aKw = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iM()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.ayK.getPageActivity(), this.aKw)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.ayK.getPageActivity(), i.h.neterror);
        }
        aVar.dismiss();
    }
}
