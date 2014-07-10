package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.EnterChatroom.DataReq;
import protobuf.EnterChatroom.EnterChatroomReqIdl;
/* loaded from: classes.dex */
public class RequestEnterChatRoomMessage extends TbSocketMessage {
    private boolean isFromLYF;
    private long lastGroupId;

    public RequestEnterChatRoomMessage() {
        super(106101);
        this.isFromLYF = false;
    }

    public RequestEnterChatRoomMessage(boolean z) {
        super(106101);
        this.isFromLYF = z;
    }

    public boolean isFromLYF() {
        return this.isFromLYF;
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
