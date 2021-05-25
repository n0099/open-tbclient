package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetLevelInfo.DataReq;
import tbclient.GetLevelInfo.GetLevelInfoReqIdl;
/* loaded from: classes4.dex */
public class GetLevelInfoRequestMessage extends NetMessage {
    public long forumId;

    public GetLevelInfoRequestMessage() {
        super(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(getForumId());
        if (z) {
            w.a(builder, true);
        }
        GetLevelInfoReqIdl.Builder builder2 = new GetLevelInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
