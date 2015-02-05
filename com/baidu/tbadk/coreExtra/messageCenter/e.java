package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Boolean)) {
            a.RF = ((Boolean) data).booleanValue();
        }
    }
}
