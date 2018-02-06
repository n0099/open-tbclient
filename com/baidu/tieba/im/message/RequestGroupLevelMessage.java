package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupGrade.DataReq;
import protobuf.QueryGroupGrade.QueryGroupGradeReqIdl;
/* loaded from: classes3.dex */
public class RequestGroupLevelMessage extends TbSocketMessage {
    private long groupId;

    public RequestGroupLevelMessage() {
        super(103006);
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
        builder.groupId = Integer.valueOf((int) this.groupId);
        QueryGroupGradeReqIdl.Builder builder2 = new QueryGroupGradeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
