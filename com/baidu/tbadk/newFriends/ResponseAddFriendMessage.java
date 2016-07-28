package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddFriend.AddFriendResIdl;
/* loaded from: classes.dex */
public class ResponseAddFriendMessage extends SocketResponsedMessage {
    private long friendId;

    public ResponseAddFriendMessage() {
        super(304100);
    }

    public long getFriendId() {
        return this.friendId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddFriendResIdl addFriendResIdl = (AddFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, AddFriendResIdl.class);
        setError(addFriendResIdl.error.errorno.intValue());
        setErrorString(addFriendResIdl.error.usermsg);
        if (getError() == 0) {
            this.friendId = addFriendResIdl.data.friend_id.longValue();
        }
    }
}
