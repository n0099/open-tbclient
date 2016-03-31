package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bg implements a.b {
    private final /* synthetic */ TbPageContext aDl;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig blG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aDl = tbPageContext;
        this.blG = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.jf()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.aDl.getPageActivity(), this.blG)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aDl.getPageActivity(), t.j.neterror);
        }
        aVar.dismiss();
    }
}
