package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.GetFrsTabFollowPostNum.DataReq;
import tbclient.GetFrsTabFollowPostNum.GetFrsTabFollowPostNumReqIdl;
/* loaded from: classes.dex */
public class GetFrsTabFollowPostNumRequest extends NetMessage {
    private long mFid;

    public void setFid(String str) {
        this.mFid = b.c(str, 0L);
    }

    public GetFrsTabFollowPostNumRequest(BdUniqueId bdUniqueId) {
        super(CmdConfigHttp.GET_FRS_TAB_FOLLOW_POST_NUM, 309346, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mFid);
        if (z) {
            o.a(builder, true);
        }
        GetFrsTabFollowPostNumReqIdl.Builder builder2 = new GetFrsTabFollowPostNumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
