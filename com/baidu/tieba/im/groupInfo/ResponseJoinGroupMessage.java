package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.ApplyJoinGroup.ApplyJoinGroupResIdl;
/* loaded from: classes.dex */
public class ResponseJoinGroupMessage extends SocketResponsedMessage {
    private int groupId;

    public ResponseJoinGroupMessage() {
        super(MessageTypes.CMD_JOIN_GROUP);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        ApplyJoinGroupResIdl applyJoinGroupResIdl = (ApplyJoinGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, ApplyJoinGroupResIdl.class);
        setError(applyJoinGroupResIdl.error.errorno.intValue());
        setErrorString(applyJoinGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = applyJoinGroupResIdl.data.groupId.intValue();
        }
    }
}
