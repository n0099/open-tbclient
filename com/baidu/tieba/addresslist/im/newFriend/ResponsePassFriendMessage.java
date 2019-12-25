package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.PassFriend.PassFriendResIdl;
/* loaded from: classes5.dex */
public class ResponsePassFriendMessage extends SocketResponsedMessage {
    private long friendId;
    private String key;
    private String name;
    private String portrait;
    private String quanpin;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getQuanpin() {
        return this.quanpin;
    }

    public void setQuanpin(String str) {
        this.quanpin = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public ResponsePassFriendMessage() {
        super(CmdConfigSocket.CMD_PASS_NEW_FRIEND);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PassFriendResIdl passFriendResIdl = (PassFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, PassFriendResIdl.class);
        setError(passFriendResIdl.error.errorno.intValue());
        setErrorString(passFriendResIdl.error.usermsg);
        if (getError() == 0) {
            this.friendId = passFriendResIdl.data.friend_info.user_id.longValue();
            this.portrait = passFriendResIdl.data.friend_info.portrait;
            this.name = passFriendResIdl.data.friend_info.user_name;
            this.key = passFriendResIdl.data.friend_info.key;
            this.quanpin = passFriendResIdl.data.friend_info.quanpin;
        }
    }
}
