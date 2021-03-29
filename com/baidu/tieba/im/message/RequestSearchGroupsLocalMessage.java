package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import protobuf.SearchGroup.DataReq;
import protobuf.SearchGroup.SearchGroupReqIdl;
/* loaded from: classes3.dex */
public class RequestSearchGroupsLocalMessage extends CustomMessage<Object> {
    public long groupId;

    public RequestSearchGroupsLocalMessage() {
        super(2001205);
    }

    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Long.valueOf(getGroupId());
            SearchGroupReqIdl.Builder builder2 = new SearchGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
