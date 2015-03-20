package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(FrsActivity frsActivity, int i) {
        super(i);
        this.aJG = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        if (customResponsedMessage != null) {
            bfVar = this.aJG.aIS;
            if (bfVar != null) {
                bfVar2 = this.aJG.aIS;
                bfVar2.mX();
            }
        }
    }
}
