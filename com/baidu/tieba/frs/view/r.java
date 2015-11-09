package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bes = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_DETAIL, new ForumDetailActivityConfig(this.bes.mContext.getContext(), this.bes.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
