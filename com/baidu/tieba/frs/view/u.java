package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ o aHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.aHR = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aHR.mContext;
        Context context = tbPageContext.getContext();
        str = this.aHR.mForumId;
        messageManager.sendMessage(new CustomMessage(2902027, new ForumDetailActivityConfig(context, str, ForumDetailActivityConfig.FromType.FRS)));
    }
}
