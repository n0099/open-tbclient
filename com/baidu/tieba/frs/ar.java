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
class ar implements a.b {
    private final /* synthetic */ TbPageContext aAk;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig aLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aAk = tbPageContext;
        this.aLE = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iL()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.aAk.getPageActivity(), this.aLE)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aAk.getPageActivity(), i.h.neterror);
        }
        aVar.dismiss();
    }
}
