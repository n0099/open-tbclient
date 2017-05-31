package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.smartsort.a;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
            com.baidu.tieba.frs.smartsort.e.ads().adt();
            a.adl().adn();
            if (com.baidu.tieba.recapp.z.aZK().aZG() != null) {
                com.baidu.tieba.recapp.z.aZK().aZG().aZx();
            }
            if (com.baidu.tieba.recapp.z.aZK().aZH() != null) {
                com.baidu.tieba.recapp.z.aZK().aZH().aZy();
            }
        }
    }
}
