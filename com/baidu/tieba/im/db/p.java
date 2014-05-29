package com.baidu.tieba.im.db;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2010015 && customResponsedMessage.getData() != null) {
            com.baidu.tieba.im.i.a(new q(this, customResponsedMessage), null);
        }
    }
}
