package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryChatroomInfo.DataReq;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReqIdl;
/* loaded from: classes.dex */
public class RequestChatRoomInfoMessage extends TbSocketMessage {
    private int groupId;

    public RequestChatRoomInfoMessage() {
        super(106001);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        QueryChatroomInfoReqIdl.Builder builder2 = new QueryChatroomInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public int getGroupId() {
        return this.groupId;
    }
}
