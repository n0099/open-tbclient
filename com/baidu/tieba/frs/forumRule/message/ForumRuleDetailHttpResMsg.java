package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.b.i0.p0.q1.c.b;
import tbclient.Error;
import tbclient.ForumRuleDetail.ForumRuleDetailResIdl;
/* loaded from: classes4.dex */
public class ForumRuleDetailHttpResMsg extends HttpResponsedMessage {
    public b mForumRuleDetailData;

    public ForumRuleDetailHttpResMsg() {
        super(CmdConfigHttp.CMD_FORUM_RULES_SHOW);
    }

    public b getmForumRuleDetailData() {
        return this.mForumRuleDetailData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumRuleDetailResIdl forumRuleDetailResIdl;
        if (bArr == null || (forumRuleDetailResIdl = (ForumRuleDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRuleDetailResIdl.class)) == null) {
            return;
        }
        Error error = forumRuleDetailResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(forumRuleDetailResIdl.error.usermsg);
        }
        if (forumRuleDetailResIdl.data != null) {
            b bVar = new b();
            this.mForumRuleDetailData = bVar;
            bVar.r(forumRuleDetailResIdl.data);
        }
    }
}
