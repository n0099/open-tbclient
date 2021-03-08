package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetLevelInfo.DataReq;
import tbclient.GetLevelInfo.GetLevelInfoReqIdl;
/* loaded from: classes7.dex */
public class GetLevelInfoRequestMessage extends NetMessage {
    private long forumId;

    public GetLevelInfoRequestMessage() {
        super(1001710, CmdConfigSocket.CMD_GET_LEVEL_INFO);
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
            v.b(builder, true);
        }
        GetLevelInfoReqIdl.Builder builder2 = new GetLevelInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
