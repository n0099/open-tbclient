package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(FrsActivity frsActivity, int i) {
        super(i);
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bl blVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        com.baidu.tieba.tbadkCore.n nVar4;
        com.baidu.tieba.tbadkCore.n nVar5;
        com.baidu.tieba.tbadkCore.n nVar6;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.n nVar7;
        com.baidu.tieba.frs.c.k kVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w)) {
            com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData();
            boolean z = wVar.isLike() == 1;
            blVar = this.this$0.aUw;
            if (blVar != null) {
                nVar = this.this$0.aUy;
                if (nVar != null) {
                    nVar2 = this.this$0.aUy;
                    if (nVar2.acG() != null) {
                        nVar3 = this.this$0.aUy;
                        nVar3.acG().setLike(wVar.isLike());
                        nVar4 = this.this$0.aUy;
                        nVar4.acG().setUser_level(wVar.ana());
                        nVar5 = this.this$0.aUy;
                        nVar5.acG().setLevelName(wVar.getLevelName());
                        if (z) {
                            aVar2 = this.this$0.aUM;
                            nVar7 = this.this$0.aUy;
                            aVar2.a(nVar7, false);
                            kVar2 = this.this$0.aUN;
                            kVar2.cj(true);
                            TbadkCoreApplication.m411getInst().addLikeForum(this.this$0.aUq);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.c.aoQ().E(this.this$0.aUq, false);
                        nVar6 = this.this$0.aUy;
                        nVar6.acG().setLike(0);
                        aVar = this.this$0.aUM;
                        aVar.Nu();
                        kVar = this.this$0.aUN;
                        kVar.cj(false);
                        TbadkCoreApplication.m411getInst().delLikeForum(this.this$0.aUq);
                    }
                }
            }
        }
    }
}
