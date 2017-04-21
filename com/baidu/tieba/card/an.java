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
    final /* synthetic */ al bvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.bvv = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bi biVar;
        com.baidu.tbadk.core.data.bi biVar2;
        com.baidu.tbadk.core.data.bi biVar3;
        com.baidu.tbadk.core.data.bi biVar4;
        com.baidu.tbadk.core.data.bi biVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bi biVar6;
        com.baidu.tieba.card.data.p pVar;
        biVar = this.bvv.aiC;
        if (biVar != null) {
            biVar2 = this.bvv.aiC;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bvv.aiC;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bvv.aiC;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bvv.aiC;
                        if (biVar5.st() != null) {
                            if (this.bvv.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bvv.getOnSubCardOnClickListenner();
                                pVar = this.bvv.bvs;
                                onSubCardOnClickListenner.a(view, pVar);
                            }
                            tbPageContext = this.bvv.ajU;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            biVar6 = this.bvv.aiC;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.g.b.c(biVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
