package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ReplyFriend.ReplyFriendResIdl;
/* loaded from: classes3.dex */
public class ResponseApplyMessage extends SocketResponsedMessage {
    public long friendId;
    public String message;

    public ResponseApplyMessage() {
        super(304103);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ReplyFriendResIdl replyFriendResIdl = (ReplyFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyFriendResIdl.class);
        setError(replyFriendResIdl.error.errorno.intValue());
        setErrorString(replyFriendResIdl.error.usermsg);
        setFriendId(replyFriendResIdl.data.friend_id.longValue());
        setMessage(replyFriendResIdl.data.message);
    }
}
