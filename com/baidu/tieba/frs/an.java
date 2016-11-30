package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.acrossForum.a;
/* loaded from: classes.dex */
class an extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public an(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a.adR().onDestory();
    }
}
