package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aOZ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(this.aOZ.LN.getContext(), this.aOZ.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
