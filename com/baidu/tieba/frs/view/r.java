package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aRA = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.aRA.LH.getContext(), this.aRA.aQR, "2", "1")));
    }
}
