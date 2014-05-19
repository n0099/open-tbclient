package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bo extends CustomMessageListener {
    final /* synthetic */ PersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(PersonalMsglistModel personalMsglistModel, int i) {
        super(i);
        this.a = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2015001) {
                this.a.c(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2003147) {
                this.a.b(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2003150) {
                this.a.a(customResponsedMessage);
            }
        }
    }
}
