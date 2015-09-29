package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(FrsActivity frsActivity, int i) {
        super(i);
        this.aUz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bs bsVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.b.k kVar;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.frs.b.k kVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData();
            boolean z = xVar.isLike() == 1;
            bsVar = this.aUz.aTJ;
            if (bsVar != null) {
                oVar = this.aUz.aTL;
                if (oVar != null) {
                    oVar2 = this.aUz.aTL;
                    if (oVar2.aeN() != null) {
                        oVar3 = this.aUz.aTL;
                        oVar3.aeN().setLike(xVar.isLike());
                        oVar4 = this.aUz.aTL;
                        oVar4.aeN().setUser_level(xVar.atx());
                        oVar5 = this.aUz.aTL;
                        oVar5.aeN().setLevelName(xVar.getLevelName());
                        if (z) {
                            aVar2 = this.aUz.aTZ;
                            oVar7 = this.aUz.aTL;
                            aVar2.a(oVar7, false);
                            kVar2 = this.aUz.aUa;
                            kVar2.cl(true);
                            TbadkCoreApplication.m411getInst().addLikeForum(this.aUz.aTB);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.d.avn().H(this.aUz.aTB, false);
                        oVar6 = this.aUz.aTL;
                        oVar6.aeN().setLike(0);
                        aVar = this.aUz.aTZ;
                        aVar.Nv();
                        kVar = this.aUz.aUa;
                        kVar.cl(false);
                        TbadkCoreApplication.m411getInst().delLikeForum(this.aUz.aTB);
                    }
                }
            }
        }
    }
}
