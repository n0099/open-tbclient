package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupByGid.DataReq;
import protobuf.QueryLiveGroupByGid.QueryLiveGroupByGidReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupInfoByGid extends TbSocketMessage {
    private int groupId;

    public RequestLiveGroupInfoByGid() {
        super(MessageTypes.CMD_GET_LIVE_GROUP_INFO);
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
