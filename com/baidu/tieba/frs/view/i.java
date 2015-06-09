package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsHeaderView frsHeaderView) {
        this.aRw = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(this.aRw.LH.getContext(), this.aRw.mForumId, ForumDetailActivityConfig.FromType.FRS)));
    }
}
