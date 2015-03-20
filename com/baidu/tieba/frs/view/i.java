package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsHeaderView frsHeaderView) {
        this.aOU = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(this.aOU.LN.getContext(), this.aOU.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
