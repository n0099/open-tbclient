package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.GetLevelInfo.DataReq;
import tbclient.GetLevelInfo.GetLevelInfoReqIdl;
/* loaded from: classes3.dex */
public class GetLevelInfoRequestMessage extends NetMessage {
    private long forumId;

    public GetLevelInfoRequestMessage() {
        super(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(getForumId());
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        GetLevelInfoReqIdl.Builder builder2 = new GetLevelInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
