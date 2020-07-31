package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetBawuInfo.DataReq;
import tbclient.GetBawuInfo.GetBawuInfoReqIdl;
/* loaded from: classes17.dex */
public class BawuTeamRequestMessage extends NetMessage {
    private long forumId;

    public BawuTeamRequestMessage() {
        super(1001705, CmdConfigSocket.CMD_BAWU_TEAM_INFO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        GetBawuInfoReqIdl.Builder builder2 = new GetBawuInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        if (z) {
            t.a(builder, true);
        }
        return builder2.build(false);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
