package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicRes;
/* loaded from: classes.dex */
public class ResponseUpdateChatroomTopicMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        UpdateChatroomTopicRes.UpdateChatroomTopicResIdl parseFrom = UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() != 0) {
        }
    }

    public ResponseUpdateChatroomTopicMessage() {
        super(106103);
    }
}
