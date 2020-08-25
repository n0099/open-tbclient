package com.baidu.tbadk.newFriends;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.PassFriend.PassFriendReqIdl;
import tbclient.PassFriend.ReqData;
/* loaded from: classes2.dex */
public class RequestPassFriendMessage extends TbSocketMessage {
    private long friendId;
    private String st_type;

    public String getSt_type() {
        return this.st_type;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j, String str) {
        this.friendId = j;
        this.st_type = str;
    }

    public RequestPassFriendMessage() {
        super(CmdConfigSocket.CMD_PASS_NEW_FRIEND);
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
}
