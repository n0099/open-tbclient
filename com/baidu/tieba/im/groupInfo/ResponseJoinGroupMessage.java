package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.ApplyJoinGroup.ApplyJoinGroupResIdl;
/* loaded from: classes23.dex */
public class ResponseJoinGroupMessage extends SocketResponsedMessage {
    private long groupId;

    public ResponseJoinGroupMessage() {
        super(CmdConfigSocket.CMD_JOIN_GROUP);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ApplyJoinGroupResIdl applyJoinGroupResIdl = (ApplyJoinGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, ApplyJoinGroupResIdl.class);
        setError(applyJoinGroupResIdl.error.errorno.intValue());
        setErrorString(applyJoinGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = applyJoinGroupResIdl.data.groupId.longValue();
        }
    }
}
