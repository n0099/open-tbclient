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
class bh implements a.b {
    private final /* synthetic */ TbPageContext azg;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig bhJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.azg = tbPageContext;
        this.bhJ = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        if (com.baidu.adp.lib.util.i.fq()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.azg.getPageActivity(), this.bhJ)));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.azg.getPageActivity(), t.j.neterror);
        }
        aVar.dismiss();
    }
}
