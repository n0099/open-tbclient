package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
            int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
            if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                FrsActivityStatic.bNM = true;
                FrsActivityStatic.bNL = true;
                return;
            }
            FrsActivityStatic.bNM = false;
            FrsActivityStatic.bNL = false;
        }
    }
}
