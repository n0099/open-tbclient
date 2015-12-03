package com.baidu.tieba.homepage.listview.card.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bAl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bAl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tieba.homepage.fragment.data.d.a(new b());
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bAl.mPageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(tbPageContext.getPageActivity(), 1)));
    }
}
