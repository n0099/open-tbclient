package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.IncrForumAccessCount.DataReq;
import tbclient.IncrForumAccessCount.IncrForumAccessCountReqIdl;
/* loaded from: classes2.dex */
public class RequestIncrForumAccessCountNetMessage extends NetMessage {
    private long mForumId;

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public RequestIncrForumAccessCountNetMessage() {
        super(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, 309360);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        if (z) {
            com.baidu.tbadk.util.o.bindCommonParamsToProtobufData(builder, true);
        }
        IncrForumAccessCountReqIdl.Builder builder2 = new IncrForumAccessCountReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
