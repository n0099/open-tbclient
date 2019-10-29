package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.DelGroupMsgs.DelGroupMsgsResIdl;
/* loaded from: classes3.dex */
public class ResponseDelSystemMessage extends SocketResponsedMessage {
    private long groupId;

    public ResponseDelSystemMessage() {
        super(CmdConfigSocket.CMD_DELETE_GROUP_MSG);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DelGroupMsgsResIdl delGroupMsgsResIdl = (DelGroupMsgsResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupMsgsResIdl.class);
        setError(delGroupMsgsResIdl.error.errorno.intValue());
        setErrorString(delGroupMsgsResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = delGroupMsgsResIdl.data.groupId.longValue();
        }
    }
}
