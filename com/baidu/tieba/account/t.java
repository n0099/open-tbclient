package com.baidu.tieba.account;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ NotLoginGuideActivity aMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(NotLoginGuideActivity notLoginGuideActivity, int i) {
        super(i);
        this.aMF = notLoginGuideActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001392 && customResponsedMessage.getData() != null) {
            this.aMF.finish();
        }
    }
}
