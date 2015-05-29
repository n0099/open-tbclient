package com.baidu.tbadk.live.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryOwnerSpeakers.DataReq;
import protobuf.QueryOwnerSpeakers.QueryOwnerSpeakersReqIdl;
/* loaded from: classes.dex */
public class RequestLiveAddBlackMembersMessage extends TbSocketMessage {
    private long groupId;
    private int offset;
    private int rn;

    public RequestLiveAddBlackMembersMessage() {
        super(107134);
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
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf((int) getGroupId());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        QueryOwnerSpeakersReqIdl.Builder builder2 = new QueryOwnerSpeakersReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
