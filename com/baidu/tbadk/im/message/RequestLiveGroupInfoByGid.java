package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupByGid.DataReq;
import protobuf.QueryLiveGroupByGid.QueryLiveGroupByGidReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupInfoByGid extends TbSocketMessage {
    private int groupId;

    public RequestLiveGroupInfoByGid() {
        super(107008);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.groupId);
        QueryLiveGroupByGidReqIdl.Builder builder2 = new QueryLiveGroupByGidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
