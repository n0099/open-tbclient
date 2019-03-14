package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.SearchGroup.DataReq;
import protobuf.SearchGroup.SearchGroupReqIdl;
/* loaded from: classes3.dex */
public class RequestSearchGroupsMessage extends TbSocketMessage {
    private long groupId;

    public RequestSearchGroupsMessage() {
        super(103007);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Long.valueOf(getGroupId());
            SearchGroupReqIdl.Builder builder2 = new SearchGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
