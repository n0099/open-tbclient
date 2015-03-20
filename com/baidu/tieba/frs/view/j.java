package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsHeaderView frsHeaderView) {
        this.aOU = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.aOU.LN.getPageActivity(), this.aOU.aOp, "2", "1")));
    }
}
