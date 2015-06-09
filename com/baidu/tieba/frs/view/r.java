package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o aRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aRB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.aRB.LH.getContext(), this.aRB.aQS, "2", "1")));
    }
}
