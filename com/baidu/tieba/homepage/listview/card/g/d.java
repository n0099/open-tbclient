package com.baidu.tieba.homepage.listview.card.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.listview.card.g.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bBn;
    private final /* synthetic */ b.C0064b bBo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, b.C0064b c0064b) {
        this.bBn = cVar;
        this.bBo = c0064b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TiebaStatic.log(new av("c10549").ab("obj_topicid", String.valueOf(this.bBo.bBd.bBa)));
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bBn.pageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(String.valueOf(this.bBo.bBd.bBa), this.bBo.bBd.bBb, "homepage")));
    }
}
