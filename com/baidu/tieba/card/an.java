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
public class an implements View.OnClickListener {
    final /* synthetic */ al bmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.bmq = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bh bhVar;
        com.baidu.tbadk.core.data.bh bhVar2;
        com.baidu.tbadk.core.data.bh bhVar3;
        com.baidu.tbadk.core.data.bh bhVar4;
        com.baidu.tbadk.core.data.bh bhVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bh bhVar6;
        com.baidu.tieba.card.data.p pVar;
        bhVar = this.bmq.acX;
        if (bhVar != null) {
            bhVar2 = this.bmq.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.bmq.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.bmq.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.bmq.acX;
                        if (bhVar5.rB() != null) {
                            if (this.bmq.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bmq.getOnSubCardOnClickListenner();
                                pVar = this.bmq.bmn;
                                onSubCardOnClickListenner.a(view, pVar);
                            }
                            tbPageContext = this.bmq.FY;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bhVar6 = this.bmq.acX;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.g.b.c(bhVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
