package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsHeaderView frsHeaderView) {
        this.aHJ = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aHJ.mContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        str = this.aHJ.aHh;
        messageManager.sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(pageActivity, str, "2", "1")));
    }
}
