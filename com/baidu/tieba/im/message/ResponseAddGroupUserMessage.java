package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.AddGroupUsers.AddGroupUsersResIdl;
/* loaded from: classes.dex */
public class ResponseAddGroupUserMessage extends SocketResponsedMessage {
    private long groupId;

    public ResponseAddGroupUserMessage() {
        super(CmdConfigSocket.CMD_ADD_GROUP_USER);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddGroupUsersResIdl addGroupUsersResIdl = (AddGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupUsersResIdl.class);
        setError(addGroupUsersResIdl.error.errorno.intValue());
        setErrorString(addGroupUsersResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = addGroupUsersResIdl.data.groupId.longValue();
        }
    }
}
