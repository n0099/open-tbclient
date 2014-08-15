package com.baidu.tbadk.newFriends;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.ReplyFriend.ReplyFriendReqIdl;
import tbclient.ReplyFriend.ReqData;
/* loaded from: classes.dex */
public class RequestApplyMessage extends TbSocketMessage {
    private long friendId;
    private String message;
    private long uid;

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public RequestApplyMessage() {
        super(304103);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.friend_id = Long.valueOf(getFriendId());
        builder.message = getMessage();
        ReplyFriendReqIdl.Builder builder2 = new ReplyFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
