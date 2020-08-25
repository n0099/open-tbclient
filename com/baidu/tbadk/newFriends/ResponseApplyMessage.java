package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.ReplyFriend.ReplyFriendResIdl;
/* loaded from: classes2.dex */
public class ResponseApplyMessage extends SocketResponsedMessage {
    private long friendId;
    private String message;

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ResponseApplyMessage() {
        super(CmdConfigSocket.CMD_APPLY_MESSAGE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ReplyFriendResIdl replyFriendResIdl = (ReplyFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyFriendResIdl.class);
        setError(replyFriendResIdl.error.errorno.intValue());
        setErrorString(replyFriendResIdl.error.usermsg);
        setFriendId(replyFriendResIdl.data.friend_id.longValue());
        setMessage(replyFriendResIdl.data.message);
    }
}
