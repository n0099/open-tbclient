package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.g.a;
/* loaded from: classes.dex */
class al extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public al(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
            com.baidu.tieba.frs.g.f.agR().agS();
            a.agJ().agL();
        }
    }
}
