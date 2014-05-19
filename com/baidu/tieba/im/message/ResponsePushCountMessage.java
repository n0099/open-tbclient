package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.CommitPusherCount.CommitPusherCountResIdl;
/* loaded from: classes.dex */
public class ResponsePushCountMessage extends SocketResponsedMessage {
    private String groupId;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public ResponsePushCountMessage() {
        super(MessageTypes.CMD_PUSH_COUNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CommitPusherCountResIdl commitPusherCountResIdl = (CommitPusherCountResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPusherCountResIdl.class);
        setError(commitPusherCountResIdl.error.errorno.intValue());
        setErrorString(commitPusherCountResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
