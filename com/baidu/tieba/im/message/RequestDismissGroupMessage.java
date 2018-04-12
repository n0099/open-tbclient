package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroup.DataReq;
import protobuf.DelGroup.DelGroupReqIdl;
/* loaded from: classes2.dex */
public class RequestDismissGroupMessage extends TbSocketMessage {
    private long groupId;

    public RequestDismissGroupMessage() {
        super(103104);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(getGroupId());
        DelGroupReqIdl.Builder builder2 = new DelGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
