package com.baidu.tieba.homepage.listview.card.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.listview.card.f.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bAO;
    private final /* synthetic */ b.a bAP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, b.a aVar) {
        this.bAO = cVar;
        this.bAP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TiebaStatic.log(new av("c10545").ab("tid", String.valueOf(this.bAP.bAE)));
        if (this.bAP.bAF == 1) {
            tbPageContext2 = this.bAO.pageContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(tbPageContext2.getPageActivity(), this.bAP.excId, null)));
        } else if (this.bAP.bAF == 3) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.bAO.pageContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.bAP.bAE), null, null)));
        }
    }
}
