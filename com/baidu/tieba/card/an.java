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
    final /* synthetic */ am bBY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bBY = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bm bmVar;
        com.baidu.tbadk.core.data.bm bmVar2;
        com.baidu.tbadk.core.data.bm bmVar3;
        com.baidu.tbadk.core.data.bm bmVar4;
        com.baidu.tbadk.core.data.bm bmVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bm bmVar6;
        com.baidu.tbadk.core.data.bm bmVar7;
        com.baidu.tieba.card.data.n nVar;
        bmVar = this.bBY.aiu;
        if (bmVar != null) {
            bmVar2 = this.bBY.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.bBY.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.bBY.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.bBY.aiu;
                        if (bmVar5.rw() != null) {
                            if (this.bBY.Vs() != null) {
                                ci<com.baidu.tieba.card.data.n> Vs = this.bBY.Vs();
                                nVar = this.bBY.bBV;
                                Vs.a(view, nVar);
                            }
                            tbPageContext = this.bBY.ajP;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bmVar6 = this.bBY.aiu;
                            long c = com.baidu.adp.lib.g.b.c(bmVar6.getAuthor().getUserId(), 0L);
                            bmVar7 = this.bBY.aiu;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, false, bmVar7.getAuthor().isBigV())));
                        }
                    }
                }
            }
        }
    }
}
