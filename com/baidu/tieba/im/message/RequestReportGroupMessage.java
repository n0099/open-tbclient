package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.ReportGroup.DataReq;
import protobuf.ReportGroup.ReportGroupReqIdl;
/* loaded from: classes3.dex */
public class RequestReportGroupMessage extends TbSocketMessage {
    private int mGroupId;
    private int mReportType;

    public RequestReportGroupMessage() {
        super(103103);
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public int getReportType() {
        return this.mReportType;
    }

    public void setReportType(int i) {
        this.mReportType = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Integer.valueOf(getGroupId());
            builder.reportType = Integer.valueOf(getReportType());
            ReportGroupReqIdl.Builder builder2 = new ReportGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
