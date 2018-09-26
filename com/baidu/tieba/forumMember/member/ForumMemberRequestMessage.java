package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetMemberInfo.DataReq;
import tbclient.GetMemberInfo.GetMemberInfoReqIdl;
/* loaded from: classes3.dex */
public class ForumMemberRequestMessage extends NetMessage {
    private long forumId;
    private String forumName;

    public ForumMemberRequestMessage() {
        super(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            com.baidu.tbadk.util.p.bindCommonParamsToProtobufData(builder, true);
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
