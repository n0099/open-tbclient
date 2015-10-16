package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bdu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsHeaderView frsHeaderView) {
        this.bdu = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_DETAIL, new ForumDetailActivityConfig(this.bdu.mContext.getContext(), this.bdu.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
