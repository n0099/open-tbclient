package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetMemberInfo.DataReq;
import tbclient.GetMemberInfo.GetMemberInfoReqIdl;
/* loaded from: classes8.dex */
public class ForumMemberRequestMessage extends NetMessage {
    private long forumId;
    private String forumName;

    public ForumMemberRequestMessage() {
        super(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            t.b(builder, true);
        }
        GetMemberInfoReqIdl.Builder builder2 = new GetMemberInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
