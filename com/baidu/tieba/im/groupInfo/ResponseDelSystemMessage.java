package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.DelGroupMsgs.DelGroupMsgsResIdl;
/* loaded from: classes.dex */
public class ResponseDelSystemMessage extends SocketResponsedMessage {
    private long groupId;

    public ResponseDelSystemMessage() {
        super(MessageTypes.CMD_DELETE_GROUP_MSG);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        DelGroupMsgsResIdl delGroupMsgsResIdl = (DelGroupMsgsResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupMsgsResIdl.class);
        setError(delGroupMsgsResIdl.error.errorno.intValue());
        setErrorString(delGroupMsgsResIdl.error.usermsg);
        if (getError() == 0) {
            setGroupId(delGroupMsgsResIdl.data.groupId.intValue());
        }
    }
}
