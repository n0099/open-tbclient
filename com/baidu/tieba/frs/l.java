package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aJQ = frsActivity;
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
            bfVar = this.aJQ.aJa;
            if (bfVar != null) {
                wVar = this.aJQ.aJd;
                if (wVar != null) {
                    wVar2 = this.aJQ.aJd;
                    if (wVar2.Za() != null) {
                        if (booleanValue) {
                            aVar2 = this.aJQ.aJt;
                            wVar4 = this.aJQ.aJd;
                            aVar2.a(wVar4, false);
                            kVar2 = this.aJQ.aJu;
                            kVar2.bX(true);
                            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                            str3 = this.aJQ.aIS;
                            m411getInst.addLikeForum(str3);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.d akD = com.baidu.tieba.tbadkCore.d.akD();
                        str = this.aJQ.aIS;
                        akD.D(str, false);
                        wVar3 = this.aJQ.aJd;
                        wVar3.Za().setLike(0);
                        aVar = this.aJQ.aJt;
                        aVar.Le();
                        kVar = this.aJQ.aJu;
                        kVar.bX(false);
                        TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                        str2 = this.aJQ.aIS;
                        m411getInst2.delLikeForum(str2);
                    }
                }
            }
        }
    }
}
