package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.AddGroupUsers.AddGroupUsersResIdl;
/* loaded from: classes4.dex */
public class ResponseAddGroupUserMessage extends SocketResponsedMessage {
    public long groupId;

    public ResponseAddGroupUserMessage() {
        super(103111);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        AddGroupUsersResIdl addGroupUsersResIdl = (AddGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupUsersResIdl.class);
        setError(addGroupUsersResIdl.error.errorno.intValue());
        setErrorString(addGroupUsersResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.groupId = addGroupUsersResIdl.data.groupId.longValue();
    }
}
