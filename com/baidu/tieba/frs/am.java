package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bhl.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.bhl.getPageContext().getPageActivity(), 23007)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10125").ac("fid", this.bhl.getForumId()).s("obj_type", 1));
    }
}
