package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public av(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            int g = com.baidu.adp.lib.h.b.g(customResponsedMessage.getData().toString(), 1);
            if (g == 1 || g == 0) {
                FrsActivityStatic.bey = false;
                FrsActivityStatic.bex = false;
            }
        }
    }
}
