package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(FrsActivity frsActivity, int i) {
        super(i);
        this.aUS = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.tbadkCore.o oVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            oVar = this.aUS.aUe;
            if (oVar != null) {
                oVar2 = this.aUS.aUe;
                oVar2.c((com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData());
                aVar = this.aUS.aUs;
                oVar3 = this.aUS.aUe;
                aVar.c(oVar3);
            }
        }
    }
}
