package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddFriend.AddFriendResIdl;
/* loaded from: classes3.dex */
public class ResponseAddFriendMessage extends SocketResponsedMessage {
    public long friendId;

    public ResponseAddFriendMessage() {
        super(304100);
    }

    public long getFriendId() {
        return this.friendId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        AddFriendResIdl addFriendResIdl = (AddFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, AddFriendResIdl.class);
        setError(addFriendResIdl.error.errorno.intValue());
        setErrorString(addFriendResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.friendId = addFriendResIdl.data.friend_id.longValue();
    }
}
