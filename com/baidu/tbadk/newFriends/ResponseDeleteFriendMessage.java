package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.DeleteFriend.DeleteFriendResIdl;
/* loaded from: classes.dex */
public class ResponseDeleteFriendMessage extends SocketResponsedMessage {
    private long friendId;

    public ResponseDeleteFriendMessage() {
        super(304102);
    }

    public long getFriendId() {
        return this.friendId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        DeleteFriendResIdl deleteFriendResIdl = (DeleteFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteFriendResIdl.class);
        setError(deleteFriendResIdl.error.errorno.intValue());
        setErrorString(deleteFriendResIdl.error.usermsg);
        if (getError() == 0) {
            this.friendId = deleteFriendResIdl.data.friend_id.longValue();
        }
    }
}
