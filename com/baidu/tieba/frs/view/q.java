package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ o aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aPq = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(this.aPq.LP.getContext(), this.aPq.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
