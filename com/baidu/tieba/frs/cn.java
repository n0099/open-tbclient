package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class cn implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDS;
    private final /* synthetic */ String bHe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(TbPageContext tbPageContext, String str) {
        this.aDS = tbPageContext;
        this.bHe = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aDS.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.aDS.getPageActivity(), 23007)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10125").ab("fid", this.bHe).s("obj_type", 1));
    }
}
