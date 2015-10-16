package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FrsActivity frsActivity, int i) {
        super(i);
        this.aUK = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.b.a aVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            oVar = this.aUK.aTW;
            if (oVar != null) {
                oVar2 = this.aUK.aTW;
                UserData userData = oVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        aVar = this.aUK.aUk;
                        aVar.b(num);
                    }
                }
            }
        }
    }
}
