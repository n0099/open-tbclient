package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ CommonGroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CommonGroupMsglistModel commonGroupMsglistModel, int i) {
        super(i);
        this.a = commonGroupMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean a;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2016012) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 202001 && (socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                        ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
                        a = this.a.a(responseCommitGroupMessage);
                        if (a) {
                            this.a.a((ResponseCommitMessage) responseCommitGroupMessage);
                        }
                    }
                }
            } else if (customResponsedMessage.getCmd() == 2001221 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                if (this.a.a != null && this.a.a.getGroupId() != 0 && chatMessage.getGroupId() != null && chatMessage.getGroupId().equals(String.valueOf(this.a.a.getGroupId()))) {
                    this.a.c(chatMessage);
                }
            }
        }
    }
}
