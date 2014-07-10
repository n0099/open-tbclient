package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupHistory.DataReq;
import protobuf.QueryLiveGroupHistory.QueryLiveGroupHistoryReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupHistoryMessage extends TbSocketMessage {
    private long groupId;
    private int offset;
    private int rn;

    public RequestLiveGroupHistoryMessage() {
        super(107005);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf((int) getGroupId());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        QueryLiveGroupHistoryReqIdl.Builder builder2 = new QueryLiveGroupHistoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
