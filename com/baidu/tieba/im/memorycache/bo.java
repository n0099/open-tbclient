package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RandChatRoomData randChatRoomData;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseEnterChatRoomMessage) && !socketResponsedMessage.hasError() && (randChatRoomData = ((ResponseEnterChatRoomMessage) socketResponsedMessage).getRandChatRoomData()) != null && randChatRoomData.e() > 0) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(randChatRoomData.d()));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.b(randChatRoomData.k()));
            imMessageCenterPojo.setCustomGroupType(3);
            imMessageCenterPojo.setIs_hidden(1);
            c.b().c(imMessageCenterPojo);
        }
    }
}
