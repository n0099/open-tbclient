package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.QuitChatroom.QuitChatroomResIdl;
/* loaded from: classes.dex */
public class ResponseQuitChatRoomMessage extends SocketResponsedMessage {
    public ResponseQuitChatRoomMessage() {
        super(MessageTypes.CMD_QUIT_CHAT_ROOM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QuitChatroomResIdl quitChatroomResIdl = (QuitChatroomResIdl) new Wire(new Class[0]).parseFrom(bArr, QuitChatroomResIdl.class);
        setError(quitChatroomResIdl.error.errorno.intValue());
        setErrorString(quitChatroomResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
