package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends CustomMessageListener {
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
        com.baidu.tieba.im.chat.bv callback;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2013001) {
                this.a.c(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001147) {
                this.a.b(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001150) {
                boolean a = this.a.a(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && a && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.f_();
                }
            }
        }
    }
}
