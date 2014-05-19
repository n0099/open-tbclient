package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.EnterChatroom.DataReq;
import protobuf.EnterChatroom.EnterChatroomReqIdl;
/* loaded from: classes.dex */
public class RequestEnterChatRoomMessage extends TbSocketMessage {
    private long lastGroupId;

    public RequestEnterChatRoomMessage() {
        super(MessageTypes.CMD_REQUEST_ENTER_CHAT_ROOM);
    }

    public long getLastGroupId() {
        return this.lastGroupId;
    }

    public void setLastGroupId(long j) {
        this.lastGroupId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.lastGroupId = Integer.valueOf((int) this.lastGroupId);
        EnterChatroomReqIdl.Builder builder2 = new EnterChatroomReqIdl.Builder();
        builder2.dataReq = builder.build(false);
        return builder2.build(false);
    }
}
