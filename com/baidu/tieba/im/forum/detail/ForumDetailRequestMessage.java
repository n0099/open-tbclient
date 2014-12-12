package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetForumDetail.DataReq;
import tbclient.GetForumDetail.GetForumDetailReqIdl;
/* loaded from: classes.dex */
public class ForumDetailRequestMessage extends NetMessage {
    private long forumId;

    public ForumDetailRequestMessage() {
        super(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021);
        this.forumId = 0L;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        GetForumDetailReqIdl.Builder builder2 = new GetForumDetailReqIdl.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
