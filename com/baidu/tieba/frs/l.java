package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aLY = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        String str;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.k kVar;
        String str2;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.frs.c.k kVar2;
        String str3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            bfVar = this.aLY.aLj;
            if (bfVar != null) {
                wVar = this.aLY.aLm;
                if (wVar != null) {
                    wVar2 = this.aLY.aLm;
                    if (wVar2.aas() != null) {
                        if (booleanValue) {
                            aVar2 = this.aLY.aLB;
                            wVar4 = this.aLY.aLm;
                            aVar2.a(wVar4, false);
                            kVar2 = this.aLY.aLC;
                            kVar2.cg(true);
                            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                            str3 = this.aLY.aLc;
                            m411getInst.addLikeForum(str3);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.d amp = com.baidu.tieba.tbadkCore.d.amp();
                        str = this.aLY.aLc;
                        amp.D(str, false);
                        wVar3 = this.aLY.aLm;
                        wVar3.aas().setLike(0);
                        aVar = this.aLY.aLB;
                        aVar.Mk();
                        kVar = this.aLY.aLC;
                        kVar.cg(false);
                        TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                        str2 = this.aLY.aLc;
                        m411getInst2.delLikeForum(str2);
                    }
                }
            }
        }
    }
}
