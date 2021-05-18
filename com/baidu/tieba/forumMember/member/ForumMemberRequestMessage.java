package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetMemberInfo.DataReq;
import tbclient.GetMemberInfo.GetMemberInfoReqIdl;
/* loaded from: classes4.dex */
public class ForumMemberRequestMessage extends NetMessage {
    public long forumId;
    public String forumName;

    public ForumMemberRequestMessage() {
        super(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            w.a(builder, true);
        }
        GetMemberInfoReqIdl.Builder builder2 = new GetMemberInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
