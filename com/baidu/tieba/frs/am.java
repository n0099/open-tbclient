package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public am(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
            com.baidu.tieba.frs.g.f.agR().agT();
        }
    }
}
