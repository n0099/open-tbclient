package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RandChatRoomData randChatRoomData;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseEnterChatRoomMessage) && !socketResponsedMessage.hasError() && (randChatRoomData = ((ResponseEnterChatRoomMessage) socketResponsedMessage).getRandChatRoomData()) != null && randChatRoomData.getUserNum() > 0) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(randChatRoomData.getGroupId()));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(randChatRoomData.getLastMessageId()));
            imMessageCenterPojo.setCustomGroupType(3);
            imMessageCenterPojo.setIs_hidden(1);
            c.PK().g(imMessageCenterPojo);
        }
    }
}
