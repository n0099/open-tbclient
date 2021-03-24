package com.baidu.tbadk.newFriends;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.PassFriend.PassFriendReqIdl;
import tbclient.PassFriend.ReqData;
/* loaded from: classes3.dex */
public class RequestPassFriendMessage extends TbSocketMessage {
    public long friendId;
    public String st_type;

    public RequestPassFriendMessage() {
        super(304101);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.friend_id = Long.valueOf(getFriendId());
        builder.st_type = getSt_type();
        PassFriendReqIdl.Builder builder2 = new PassFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setFriendId(long j, String str) {
        this.friendId = j;
        this.st_type = str;
    }
}
