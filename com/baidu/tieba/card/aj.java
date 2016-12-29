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
    final /* synthetic */ ah bcB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.bcB = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bg bgVar;
        com.baidu.tbadk.core.data.bg bgVar2;
        com.baidu.tbadk.core.data.bg bgVar3;
        com.baidu.tbadk.core.data.bg bgVar4;
        com.baidu.tbadk.core.data.bg bgVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bg bgVar6;
        com.baidu.tieba.card.data.o oVar;
        bgVar = this.bcB.adN;
        if (bgVar != null) {
            bgVar2 = this.bcB.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.bcB.adN;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.bcB.adN;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.bcB.adN;
                        if (bgVar5.rK() != null) {
                            if (this.bcB.getOnSubCardOnClickListenner() != null) {
                                cb<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bcB.getOnSubCardOnClickListenner();
                                oVar = this.bcB.bcy;
                                onSubCardOnClickListenner.a(view, oVar);
                            }
                            tbPageContext = this.bcB.GO;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bgVar6 = this.bcB.adN;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.h.b.c(bgVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
