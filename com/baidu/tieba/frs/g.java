package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FrsActivity frsActivity, int i) {
        super(i);
        this.bQa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        UserData userData;
        com.baidu.tieba.frs.g.u uVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.bQa.bOV != null && (userData = this.bQa.bOV.getUserData()) != null) {
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                uVar = this.bQa.bPg;
                uVar.a(num);
            }
        }
    }
}
