package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.AddFriend.AddFriendReqIdl;
import tbclient.AddFriend.ReqData;
/* loaded from: classes4.dex */
public class RequestAddFriendMessage extends TbSocketMessage {
    public long friendId;
    public String message;
    public String st_type;

    public RequestAddFriendMessage() {
        super(304100);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.friend_id = Long.valueOf(getFriendId());
        builder.message = getMessage();
        builder.st_type = getSt_type();
        AddFriendReqIdl.Builder builder2 = new AddFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }
}
