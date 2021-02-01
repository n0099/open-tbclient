package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import protobuf.SearchGroup.DataReq;
import protobuf.SearchGroup.SearchGroupReqIdl;
/* loaded from: classes8.dex */
public class RequestSearchGroupsLocalMessage extends CustomMessage<Object> {
    private long groupId;

    public RequestSearchGroupsLocalMessage() {
        super(CmdConfigCustom.CMD_CACHE_REQUEST_SEARCH_GROUP);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

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
