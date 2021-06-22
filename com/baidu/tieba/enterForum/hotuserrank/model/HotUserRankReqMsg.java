package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetInfluenceRank.DataReq;
import tbclient.GetInfluenceRank.GetInfluenceRankReqIdl;
/* loaded from: classes4.dex */
public class HotUserRankReqMsg extends NetMessage {
    public String category;
    public long forumId;
    public int pageNum;
    public int pageSize;

    public HotUserRankReqMsg() {
        super(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.tieba_name = this.category;
        builder.forum_id = Long.valueOf(this.forumId);
        builder.rn = Integer.valueOf(this.pageSize);
        builder.pn = Integer.valueOf(this.pageNum);
        GetInfluenceRankReqIdl.Builder builder2 = new GetInfluenceRankReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
