package com.baidu.tieba.homepage.listview.card.j;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bCb;
    private final /* synthetic */ b bCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, b bVar) {
        this.bCb = cVar;
        this.bCc = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        com.baidu.tieba.homepage.fragment.data.d.a(this.bCc);
        tbPageContext = this.bCb.pageContext;
        if (bj.ah(tbPageContext.getPageActivity())) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext2 = this.bCb.mPageContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(tbPageContext2.getPageActivity())));
        }
    }
}
