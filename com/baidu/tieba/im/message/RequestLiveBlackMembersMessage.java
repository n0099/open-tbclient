package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryOwnerGagList.DataReq;
import protobuf.QueryOwnerGagList.QueryOwnerGagListReqIdl;
/* loaded from: classes.dex */
public class RequestLiveBlackMembersMessage extends TbSocketMessage {
    private long groupId;
    private int offset;
    private int rn;

    public RequestLiveBlackMembersMessage() {
        super(107009);
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
        QueryOwnerGagListReqIdl.Builder builder2 = new QueryOwnerGagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
