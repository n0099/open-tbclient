package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai bvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.bvr = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bk bkVar;
        com.baidu.tbadk.core.data.bk bkVar2;
        com.baidu.tbadk.core.data.bk bkVar3;
        com.baidu.tbadk.core.data.bk bkVar4;
        com.baidu.tbadk.core.data.bk bkVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bk bkVar6;
        com.baidu.tieba.card.data.n nVar;
        bkVar = this.bvr.ahV;
        if (bkVar != null) {
            bkVar2 = this.bvr.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bvr.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bvr.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bvr.ahV;
                        if (bkVar5.rD() != null) {
                            if (this.bvr.getOnSubCardOnClickListenner() != null) {
                                cd<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvr.getOnSubCardOnClickListenner();
                                nVar = this.bvr.bvo;
                                onSubCardOnClickListenner.a(view, nVar);
                            }
                            tbPageContext = this.bvr.ajr;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bkVar6 = this.bvr.ahV;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.g.b.c(bkVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
