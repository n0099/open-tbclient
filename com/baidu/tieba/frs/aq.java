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
class aq implements a.b {
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aLr;
    private final /* synthetic */ TbPageContext ayC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.ayC = tbPageContext;
        this.aLr = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iO()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.ayC.getPageActivity(), this.aLr)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.ayC.getPageActivity(), i.C0057i.neterror);
        }
        aVar.dismiss();
    }
}
