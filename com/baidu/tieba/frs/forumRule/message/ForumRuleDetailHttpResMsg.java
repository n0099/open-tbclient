package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.forumRule.b.b;
import com.squareup.wire.Wire;
import tbclient.ForumRuleDetail.ForumRuleDetailResIdl;
/* loaded from: classes2.dex */
public class ForumRuleDetailHttpResMsg extends HttpResponsedMessage {
    private b mForumRuleDetailData;

    public ForumRuleDetailHttpResMsg() {
        super(CmdConfigHttp.CMD_FORUM_RULES_SHOW);
    }

    public b getmForumRuleDetailData() {
        return this.mForumRuleDetailData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumRuleDetailResIdl forumRuleDetailResIdl;
        if (bArr != null && (forumRuleDetailResIdl = (ForumRuleDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRuleDetailResIdl.class)) != null) {
            if (forumRuleDetailResIdl.error != null) {
                setError(forumRuleDetailResIdl.error.errorno.intValue());
                setErrorString(forumRuleDetailResIdl.error.usermsg);
            }
            if (forumRuleDetailResIdl.data != null) {
                this.mForumRuleDetailData = new b();
                this.mForumRuleDetailData.a(forumRuleDetailResIdl.data);
            }
        }
    }
}
