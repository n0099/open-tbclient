package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ax extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (com.baidu.adp.lib.g.c.f(customResponsedMessage.getData().toString(), 1) == 1) {
                FrsActivity.aAl = false;
                FrsActivity.aAk = false;
                return;
            }
            FrsActivity.aAm = false;
            FrsActivity.aAk = false;
        }
    }
}
