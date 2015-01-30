package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(FloatingPersonalChatActivity floatingPersonalChatActivity, int i) {
        super(i);
        this.bab = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FloatingPersonalChatView floatingPersonalChatView;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003) {
            floatingPersonalChatView = this.bab.aZZ;
            floatingPersonalChatView.f(customResponsedMessage);
        }
    }
}
