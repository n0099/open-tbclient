package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            pVar = this.bDB.bCF;
            if (pVar != null) {
                pVar2 = this.bDB.bCF;
                UserData userData = pVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        pVar3 = this.bDB.bCR;
                        pVar3.a(num);
                    }
                }
            }
        }
    }
}
