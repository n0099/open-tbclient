package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.ForumRuleDetail.DataReq;
import tbclient.ForumRuleDetail.ForumRuleDetailReqIdl;
/* loaded from: classes4.dex */
public class ForumRuleDetailReqMsg extends NetMessage {
    public Long mForumRuleId;

    public ForumRuleDetailReqMsg() {
        super(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
    }

    private Long getForumRuleId() {
        return this.mForumRuleId;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = getForumRuleId();
            if (z) {
                w.c(builder, true, true, false);
            }
            ForumRuleDetailReqIdl.Builder builder2 = new ForumRuleDetailReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void setForumRuleId(Long l) {
        this.mForumRuleId = l;
    }
}
