package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsHeaderView frsHeaderView) {
        this.aRv = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.aRv.LH.getPageActivity(), this.aRv.aQR, "2", "1")));
    }
}
