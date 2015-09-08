package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FrsActivity frsActivity, int i) {
        super(i);
        this.aVz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2012111) {
            int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
            if (intValue == 1 || intValue == 4 || intValue == 3) {
                FrsActivityStatic.aVI = true;
            } else if (intValue == 2) {
                FrsActivityStatic.aVJ = true;
            }
            boolean z = intValue == 3;
            boolean Lv = FrsActivityStatic.Lv();
            if (z && Lv) {
                FrsActivityStatic.aVH = false;
            } else {
                FrsActivityStatic.aVH = true;
            }
            this.aVz.KX();
        }
    }
}
