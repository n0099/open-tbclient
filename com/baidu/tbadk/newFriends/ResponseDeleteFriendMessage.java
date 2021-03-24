package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.DeleteFriend.DeleteFriendResIdl;
/* loaded from: classes3.dex */
public class ResponseDeleteFriendMessage extends SocketResponsedMessage {
    public long friendId;

    public ResponseDeleteFriendMessage() {
        super(304102);
    }

    public long getFriendId() {
        return this.friendId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DeleteFriendResIdl deleteFriendResIdl = (DeleteFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteFriendResIdl.class);
        setError(deleteFriendResIdl.error.errorno.intValue());
        setErrorString(deleteFriendResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.friendId = deleteFriendResIdl.data.friend_id.longValue();
    }
}
