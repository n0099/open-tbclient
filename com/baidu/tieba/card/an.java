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
    final /* synthetic */ al btk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.btk = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bj bjVar;
        com.baidu.tbadk.core.data.bj bjVar2;
        com.baidu.tbadk.core.data.bj bjVar3;
        com.baidu.tbadk.core.data.bj bjVar4;
        com.baidu.tbadk.core.data.bj bjVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bj bjVar6;
        com.baidu.tieba.card.data.p pVar;
        bjVar = this.btk.ain;
        if (bjVar != null) {
            bjVar2 = this.btk.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.btk.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.btk.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.btk.ain;
                        if (bjVar5.rV() != null) {
                            if (this.btk.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.btk.getOnSubCardOnClickListenner();
                                pVar = this.btk.bth;
                                onSubCardOnClickListenner.a(view, pVar);
                            }
                            tbPageContext = this.btk.ajF;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bjVar6 = this.btk.ain;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.g.b.c(bjVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
