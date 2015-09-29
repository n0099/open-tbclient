package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aUz.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.aUz.getPageContext().getPageActivity(), 23003)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10125").ae(ImageViewerConfig.FORUM_ID, this.aUz.getForumId()).r("obj_type", 2));
    }
}
