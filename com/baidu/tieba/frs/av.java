package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Ft;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2012111) {
            int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
            if (intValue == 1 || intValue == 4 || intValue == 3) {
                FrsActivity.aBN = true;
            } else if (intValue == 2) {
                FrsActivity.aBO = true;
            }
            boolean z = intValue == 3;
            Ft = FrsActivity.Ft();
            if (!z || !Ft) {
                FrsActivity.aBM = true;
            } else {
                FrsActivity.aBM = false;
            }
            this.aCV.Fx();
        }
    }
}
