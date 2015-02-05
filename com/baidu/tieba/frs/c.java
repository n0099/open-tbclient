package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FrsActivity frsActivity, int i) {
        super(i);
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bp bpVar;
        bp bpVar2;
        if (customResponsedMessage != null) {
            bpVar = this.aDT.aCV;
            if (bpVar != null) {
                bpVar2 = this.aDT.aCV;
                bpVar2.jC();
            }
        }
    }
}
