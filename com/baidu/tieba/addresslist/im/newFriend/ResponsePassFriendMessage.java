package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.PassFriend.PassFriendResIdl;
import tbclient.PassFriend.friendInfo;
/* loaded from: classes4.dex */
public class ResponsePassFriendMessage extends SocketResponsedMessage {
    public long friendId;
    public String key;
    public String name;
    public String portrait;
    public String quanpin;

    public ResponsePassFriendMessage() {
        super(304101);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getQuanpin() {
        return this.quanpin;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setQuanpin(String str) {
        this.quanpin = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        PassFriendResIdl passFriendResIdl = (PassFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, PassFriendResIdl.class);
        setError(passFriendResIdl.error.errorno.intValue());
        setErrorString(passFriendResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.friendId = passFriendResIdl.data.friend_info.user_id.longValue();
        friendInfo friendinfo = passFriendResIdl.data.friend_info;
        this.portrait = friendinfo.portrait;
        this.name = friendinfo.user_name;
        this.key = friendinfo.key;
        this.quanpin = friendinfo.quanpin;
    }
}
