package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsHeaderView frsHeaderView) {
        this.aHJ = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aHJ.mContext;
        Context context = tbPageContext.getContext();
        str = this.aHJ.mForumId;
        messageManager.sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(context, str, ForumDetailActivityConfig.FromType.FRS)));
    }
}
