package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetForumDetail.DataReq;
import tbclient.GetForumDetail.GetForumDetailReqIdl;
/* loaded from: classes3.dex */
public class ForumDetailRequestMessage extends NetMessage {
    public long forumId;

    public ForumDetailRequestMessage() {
        super(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021);
        this.forumId = 0L;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetForumDetailReqIdl.Builder builder2 = new GetForumDetailReqIdl.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
