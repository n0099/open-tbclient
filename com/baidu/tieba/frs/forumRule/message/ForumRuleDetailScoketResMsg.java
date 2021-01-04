package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.frs.forumRule.b.b;
import com.squareup.wire.Wire;
import tbclient.ForumRuleDetail.ForumRuleDetailResIdl;
/* loaded from: classes2.dex */
public class ForumRuleDetailScoketResMsg extends SocketResponsedMessage {
    private b mForumRuleDetailData;

    public ForumRuleDetailScoketResMsg() {
        super(309690);
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
