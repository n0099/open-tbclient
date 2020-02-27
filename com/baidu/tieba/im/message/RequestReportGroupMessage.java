package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.ReportGroup.DataReq;
import protobuf.ReportGroup.ReportGroupReqIdl;
/* loaded from: classes10.dex */
public class RequestReportGroupMessage extends TbSocketMessage {
    private long mGroupId;
    private int mReportType;

    public RequestReportGroupMessage() {
        super(CmdConfigSocket.CMD_REPORT_GROUP);
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
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
            builder.groupId = Long.valueOf(getGroupId());
            builder.reportType = Integer.valueOf(getReportType());
            ReportGroupReqIdl.Builder builder2 = new ReportGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
