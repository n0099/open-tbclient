package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.aVz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bi biVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.frs.c.k kVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData();
            boolean z = xVar.isLike() == 1;
            biVar = this.aVz.aUL;
            if (biVar != null) {
                oVar = this.aVz.aUN;
                if (oVar != null) {
                    oVar2 = this.aVz.aUN;
                    if (oVar2.acP() != null) {
                        oVar3 = this.aVz.aUN;
                        oVar3.acP().setLike(xVar.isLike());
                        oVar4 = this.aVz.aUN;
                        oVar4.acP().setUser_level(xVar.arj());
                        oVar5 = this.aVz.aUN;
                        oVar5.acP().setLevelName(xVar.getLevelName());
                        if (z) {
                            aVar2 = this.aVz.aVb;
                            oVar7 = this.aVz.aUN;
                            aVar2.a(oVar7, false);
                            kVar2 = this.aVz.aVc;
                            kVar2.co(true);
                            TbadkCoreApplication.m411getInst().addLikeForum(this.aVz.aUF);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.d.asX().G(this.aVz.aUF, false);
                        oVar6 = this.aVz.aUN;
                        oVar6.acP().setLike(0);
                        aVar = this.aVz.aVb;
                        aVar.Nv();
                        kVar = this.aVz.aVc;
                        kVar.co(false);
                        TbadkCoreApplication.m411getInst().delLikeForum(this.aVz.aUF);
                    }
                }
            }
        }
    }
}
