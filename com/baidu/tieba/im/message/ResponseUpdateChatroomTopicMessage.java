package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateChatroomTopicMessage extends SocketResponsedMessage {
    public ResponseUpdateChatroomTopicMessage() {
        super(MessageTypes.CMD_UPDATE_CHATROOM_TOPIC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateChatroomTopicResIdl updateChatroomTopicResIdl = (UpdateChatroomTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateChatroomTopicResIdl.class);
        setError(updateChatroomTopicResIdl.error.errorno.intValue());
        setErrorString(updateChatroomTopicResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
