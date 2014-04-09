package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
public class ResponseQuitChatRoomMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QuitChatroomRes.QuitChatroomResIdl parseFrom = QuitChatroomRes.QuitChatroomResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() != 0) {
        }
    }

    public ResponseQuitChatRoomMessage() {
        super(106102);
    }
}
