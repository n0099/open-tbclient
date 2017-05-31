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
    final /* synthetic */ am bBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bBf = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bl blVar;
        com.baidu.tbadk.core.data.bl blVar2;
        com.baidu.tbadk.core.data.bl blVar3;
        com.baidu.tbadk.core.data.bl blVar4;
        com.baidu.tbadk.core.data.bl blVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bl blVar6;
        com.baidu.tbadk.core.data.bl blVar7;
        com.baidu.tieba.card.data.n nVar;
        blVar = this.bBf.ahM;
        if (blVar != null) {
            blVar2 = this.bBf.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.bBf.ahM;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.bBf.ahM;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.bBf.ahM;
                        if (blVar5.rz() != null) {
                            if (this.bBf.Ud() != null) {
                                ci<com.baidu.tieba.card.data.n> Ud = this.bBf.Ud();
                                nVar = this.bBf.bBc;
                                Ud.a(view, nVar);
                            }
                            tbPageContext = this.bBf.ajh;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            blVar6 = this.bBf.ahM;
                            long c = com.baidu.adp.lib.g.b.c(blVar6.getAuthor().getUserId(), 0L);
                            blVar7 = this.bBf.ahM;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, false, blVar7.getAuthor().isBigV())));
                        }
                    }
                }
            }
        }
    }
}
