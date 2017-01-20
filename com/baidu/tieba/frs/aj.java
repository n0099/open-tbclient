package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            int g = b.g(customResponsedMessage.getData().toString(), 1);
            if (g == 1 || g == 0) {
                FrsActivityStatic.bGS = false;
                FrsActivityStatic.bGR = false;
            }
        }
    }
}
