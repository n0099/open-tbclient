package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(FrsActivity frsActivity, int i) {
        super(i);
        this.bEL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        UserData userData;
        com.baidu.tieba.frs.j.p pVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.bEL.bDM != null && (userData = this.bEL.bDM.getUserData()) != null) {
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                pVar = this.bEL.bDY;
                pVar.a(num);
            }
        }
    }
}
