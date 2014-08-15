package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import protobuf.SearchGroup.DataReq;
import protobuf.SearchGroup.SearchGroupReqIdl;
/* loaded from: classes.dex */
public class RequestSearchGroupsLocalMessage extends CustomMessage<Object> {
    private int groupId;

    public RequestSearchGroupsLocalMessage() {
        super(2001211);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Integer.valueOf(getGroupId());
            SearchGroupReqIdl.Builder builder2 = new SearchGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
