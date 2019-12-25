package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroup.DataReq;
import protobuf.DelGroup.DelGroupReqIdl;
/* loaded from: classes5.dex */
public class RequestDismissGroupMessage extends TbSocketMessage {
    private long groupId;

    public RequestDismissGroupMessage() {
        super(CmdConfigSocket.CMD_DISSMISS_GROUP);
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
