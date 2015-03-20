package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aOZ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.aOZ.LN.getContext(), this.aOZ.aOp, "2", "1")));
    }
}
