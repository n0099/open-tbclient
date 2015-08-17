package com.baidu.tbadk.live.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupByGidAndPid.DataReq;
import protobuf.QueryLiveGroupByGidAndPid.QueryLiveGroupByGidAndPidReqIdl;
/* loaded from: classes.dex */
public class RequestLiveRoomIntroMessage extends TbSocketMessage {
    private int mGroupId;
    private long mPublisherId;

    public RequestLiveRoomIntroMessage() {
        super(107004);
        this.mGroupId = 0;
        this.mPublisherId = 0L;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        builder.publisherId = Long.valueOf(getPublisherId());
        QueryLiveGroupByGidAndPidReqIdl.Builder builder2 = new QueryLiveGroupByGidAndPidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public void setPublisherId(long j) {
        this.mPublisherId = j;
    }

    public long getPublisherId() {
        return this.mPublisherId;
    }
}
