package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.RequestQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseQuitChatRoomMessage) && !socketResponsedMessage.hasError()) {
            ResponseQuitChatRoomMessage responseQuitChatRoomMessage = (ResponseQuitChatRoomMessage) socketResponsedMessage;
            if (responseQuitChatRoomMessage.getOrginalMessage() != null && (responseQuitChatRoomMessage.getOrginalMessage() instanceof RequestQuitChatRoomMessage)) {
                c.PK().D(String.valueOf(((RequestQuitChatRoomMessage) responseQuitChatRoomMessage.getOrginalMessage()).getGroupId()), 3);
            }
        }
    }
}
