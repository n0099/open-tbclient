package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupGrade.DataReq;
import protobuf.QueryGroupGrade.QueryGroupGradeReqIdl;
/* loaded from: classes5.dex */
public class RequestGroupLevelMessage extends TbSocketMessage {
    private long groupId;

    public RequestGroupLevelMessage() {
        super(CmdConfigSocket.CMD_REQUEST_GROUPLEVEL_BY_ID);
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
        builder.groupId = Long.valueOf(this.groupId);
        QueryGroupGradeReqIdl.Builder builder2 = new QueryGroupGradeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
