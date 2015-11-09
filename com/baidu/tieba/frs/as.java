package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class as extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public as(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
            int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
            if (intValue == 1 || intValue == 4 || intValue == 3) {
                FrsActivityStatic.aVj = true;
            } else if (intValue == 2) {
                FrsActivityStatic.aVk = true;
            }
            boolean z = intValue == 3;
            boolean LE = FrsActivityStatic.LE();
            if (z && LE) {
                FrsActivityStatic.aVi = false;
            } else {
                FrsActivityStatic.aVi = true;
            }
        }
    }
}
