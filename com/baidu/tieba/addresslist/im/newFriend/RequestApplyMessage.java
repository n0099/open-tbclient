package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.ReplyFriend.ReplyFriendReqIdl;
import tbclient.ReplyFriend.ReqData;
/* loaded from: classes4.dex */
public class RequestApplyMessage extends TbSocketMessage {
    public long friendId;
    public String message;
    public long uid;

    public RequestApplyMessage() {
        super(304103);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.friend_id = Long.valueOf(getFriendId());
        builder.message = getMessage();
        ReplyFriendReqIdl.Builder builder2 = new ReplyFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getMessage() {
        return this.message;
    }

    public long getUid() {
        return this.uid;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }
}
