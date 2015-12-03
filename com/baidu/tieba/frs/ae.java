package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bag.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.bag.getPageContext().getPageActivity(), 23007)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10125").ab(ImageViewerConfig.FORUM_ID, this.bag.getForumId()).r("obj_type", 1));
    }
}
