package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(FrsActivity frsActivity, int i) {
        super(i);
        this.aJG = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2012111) {
            int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
            if (intValue == 1 || intValue == 4 || intValue == 3) {
                FrsActivityStatic.aJP = true;
            } else if (intValue == 2) {
                FrsActivityStatic.aJQ = true;
            }
            boolean z = intValue == 3;
            boolean JF = FrsActivityStatic.JF();
            if (z && JF) {
                FrsActivityStatic.aJO = false;
            } else {
                FrsActivityStatic.aJO = true;
            }
            this.aJG.Jk();
        }
    }
}
