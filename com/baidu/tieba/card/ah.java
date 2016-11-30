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
    final /* synthetic */ af bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bdj = afVar;
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
        com.baidu.tieba.card.data.o oVar;
        bkVar = this.bdj.aeu;
        if (bkVar != null) {
            bkVar2 = this.bdj.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bdj.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bdj.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bdj.aeu;
                        if (bkVar5.getForum_name() != null) {
                            if (this.bdj.getOnSubCardOnClickListenner() != null) {
                                bz<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bdj.getOnSubCardOnClickListenner();
                                oVar = this.bdj.bdg;
                                onSubCardOnClickListenner.a(view, oVar);
                            }
                            tbPageContext = this.bdj.GO;
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                            bkVar6 = this.bdj.aeu;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.h.b.c(bkVar6.getAuthor().getUserId(), 0L), false)));
                        }
                    }
                }
            }
        }
    }
}
