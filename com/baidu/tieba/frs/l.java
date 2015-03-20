package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aJG = frsActivity;
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
            bfVar = this.aJG.aIS;
            if (bfVar != null) {
                wVar = this.aJG.aIV;
                if (wVar != null) {
                    wVar2 = this.aJG.aIV;
                    if (wVar2.YO() != null) {
                        if (booleanValue) {
                            aVar2 = this.aJG.aJl;
                            wVar4 = this.aJG.aIV;
                            aVar2.a(wVar4, false);
                            kVar2 = this.aJG.aJm;
                            kVar2.bZ(true);
                            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                            str3 = this.aJG.aIK;
                            m411getInst.addLikeForum(str3);
                            return;
                        }
                        com.baidu.tieba.tbadkCore.d ako = com.baidu.tieba.tbadkCore.d.ako();
                        str = this.aJG.aIK;
                        ako.D(str, false);
                        wVar3 = this.aJG.aIV;
                        wVar3.YO().setLike(0);
                        aVar = this.aJG.aJl;
                        aVar.KS();
                        kVar = this.aJG.aJm;
                        kVar.bZ(false);
                        TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                        str2 = this.aJG.aIK;
                        m411getInst2.delLikeForum(str2);
                    }
                }
            }
        }
    }
}
