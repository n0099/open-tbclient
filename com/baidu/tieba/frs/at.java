package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public at(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (com.baidu.adp.lib.g.c.toInt(customResponsedMessage.getData().toString(), 1) == 1) {
                FrsActivity.aCO = false;
                FrsActivity.aCN = false;
                return;
            }
            FrsActivity.aCP = false;
            FrsActivity.aCN = false;
        }
    }
}
