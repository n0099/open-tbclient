package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.AddGroupUsers.AddGroupUsersResIdl;
/* loaded from: classes.dex */
public class ResponseAddGroupUserMessage extends SocketResponsedMessage {
    private int groupId;

    public ResponseAddGroupUserMessage() {
        super(103111);
    }

    public int getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        AddGroupUsersResIdl addGroupUsersResIdl = (AddGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupUsersResIdl.class);
        setError(addGroupUsersResIdl.error.errorno.intValue());
        setErrorString(addGroupUsersResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = addGroupUsersResIdl.data.groupId.intValue();
        }
    }
}
