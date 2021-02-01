package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.ForumRuleDetail.DataReq;
import tbclient.ForumRuleDetail.ForumRuleDetailReqIdl;
/* loaded from: classes2.dex */
public class ForumRuleDetailReqMsg extends NetMessage {
    private Long mForumRuleId;

    public ForumRuleDetailReqMsg() {
        super(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
    }

    private Long getForumRuleId() {
        return this.mForumRuleId;
    }

    public void setForumRuleId(Long l) {
        this.mForumRuleId = l;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = getForumRuleId();
            if (z) {
                v.a(builder, true, true, false);
            }
            ForumRuleDetailReqIdl.Builder builder2 = new ForumRuleDetailReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
