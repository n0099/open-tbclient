package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.DelGroupUsers.DelGroupUsersResIdl;
/* loaded from: classes6.dex */
public class ResponseRemoveMembersMessage extends SocketResponsedMessage {
    private String groupId;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public ResponseRemoveMembersMessage() {
        super(103112);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DelGroupUsersResIdl delGroupUsersResIdl = (DelGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupUsersResIdl.class);
        setError(delGroupUsersResIdl.error.errorno.intValue());
        setErrorString(delGroupUsersResIdl.error.usermsg);
        if (getError() == 0) {
            setGroupId(String.valueOf(delGroupUsersResIdl.data.groupId));
        }
    }
}
