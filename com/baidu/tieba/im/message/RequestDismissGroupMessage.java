package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroup.DataReq;
import protobuf.DelGroup.DelGroupReqIdl;
/* loaded from: classes.dex */
public class RequestDismissGroupMessage extends TbSocketMessage {
    private int groupId;

    public RequestDismissGroupMessage() {
        super(103104);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        DelGroupReqIdl.Builder builder2 = new DelGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
