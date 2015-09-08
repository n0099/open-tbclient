package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class al extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public al(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), 1) == 1) {
                FrsActivityStatic.aVI = false;
                FrsActivityStatic.aVH = false;
                return;
            }
            FrsActivityStatic.aVJ = false;
            FrsActivityStatic.aVH = false;
        }
    }
}
