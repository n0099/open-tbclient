package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.AddFriend.AddFriendReqIdl;
import tbclient.AddFriend.ReqData;
/* loaded from: classes8.dex */
public class RequestAddFriendMessage extends TbSocketMessage {
    private long friendId;
    private String message;
    private String st_type;

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

    public String getSt_type() {
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public RequestAddFriendMessage() {
        super(CmdConfigSocket.CMD_ADD_NEW_FRIEND);
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
}
