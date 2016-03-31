package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.blk.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.blk.getPageContext().getPageActivity(), 23007)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10125").ac("fid", this.blk.getForumId()).r("obj_type", 1));
    }
}
