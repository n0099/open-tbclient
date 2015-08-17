package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FrsActivity frsActivity, int i) {
        super(i);
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.n nVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w)) {
            nVar = this.this$0.aUy;
            if (nVar != null) {
                nVar2 = this.this$0.aUy;
                nVar2.b((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                aVar = this.this$0.aUM;
                nVar3 = this.this$0.aUy;
                aVar.d(nVar3);
            }
        }
    }
}
