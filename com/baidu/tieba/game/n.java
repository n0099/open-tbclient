package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean booleanValue;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue())) {
            l.Hi().cm(booleanValue);
        }
    }
}
