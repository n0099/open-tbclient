package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.smartsort.a;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
            com.baidu.tieba.frs.smartsort.e.aem().aen();
            a.aee().aeg();
            if (com.baidu.tieba.recapp.v.baQ().baN() != null) {
                com.baidu.tieba.recapp.v.baQ().baN().baE();
            }
        }
    }
}
