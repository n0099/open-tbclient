package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements a.b {
    private final /* synthetic */ TbPageContext aBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(TbPageContext tbPageContext) {
        this.aBy = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aBy.getPageActivity(), "com.baidu.tieba.pluginHomework")));
        aVar.dismiss();
    }
}
