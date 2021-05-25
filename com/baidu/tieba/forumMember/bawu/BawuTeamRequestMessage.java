package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetBawuInfo.DataReq;
import tbclient.GetBawuInfo.GetBawuInfoReqIdl;
/* loaded from: classes4.dex */
public class BawuTeamRequestMessage extends NetMessage {
    public long forumId;

    public BawuTeamRequestMessage() {
        super(CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        GetBawuInfoReqIdl.Builder builder2 = new GetBawuInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        if (z) {
            w.a(builder, true);
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
