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
class bd implements a.b {
    private final /* synthetic */ TbPageContext aCn;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig bgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.aCn = tbPageContext;
        this.bgV = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.i.iZ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.aCn.getPageActivity(), this.bgV)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aCn.getPageActivity(), t.j.neterror);
        }
        aVar.dismiss();
    }
}
