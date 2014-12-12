package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class au extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public au(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (com.baidu.adp.lib.g.c.toInt(customResponsedMessage.getData().toString(), 1) == 1) {
                FrsActivity.aBN = false;
                FrsActivity.aBM = false;
                return;
            }
            FrsActivity.aBO = false;
            FrsActivity.aBM = false;
        }
    }
}
