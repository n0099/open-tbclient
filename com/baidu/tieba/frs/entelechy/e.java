package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bnY = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bnY.Do;
        Context context = tbPageContext.getContext();
        str = this.bnY.mForumId;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_DETAIL, new ForumDetailActivityConfig(context, str, ForumDetailActivityConfig.FromType.FRS)));
    }
}
