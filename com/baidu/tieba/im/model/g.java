package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ CommonPersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CommonPersonalMsglistModel commonPersonalMsglistModel, int i) {
        super(i);
        this.a = commonPersonalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2016012) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                        this.a.a((ResponseCommitPersonalMessage) socketResponsedMessage);
                    }
                }
            } else if (customResponsedMessage.getCmd() == 2001221 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                if (this.a.a != null && this.a.a.getUserId() != null) {
                    if (this.a.a.getUserId().equals(String.valueOf(com.baidu.tieba.im.d.j.a(chatMessage)))) {
                        this.a.c(chatMessage);
                    }
                }
            }
        }
    }
}
