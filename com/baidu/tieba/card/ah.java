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
public class ah implements View.OnClickListener {
    final /* synthetic */ af bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bab = afVar;
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
        com.baidu.tieba.card.data.o oVar;
        biVar = this.bab.adW;
        if (biVar != null) {
            biVar2 = this.bab.adW;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bab.adW;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bab.adW;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bab.adW;
                        if (biVar5.getForum_name() != null) {
                            if (this.bab.getOnSubCardOnClickListenner() != null) {
                                cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bab.getOnSubCardOnClickListenner();
                                oVar = this.bab.aZY;
                                onSubCardOnClickListenner.a(view, oVar);
                            }
                            tbPageContext = this.bab.GM;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            biVar6 = this.bab.adW;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.h.b.c(biVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
