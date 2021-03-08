package com.baidu.tieba.forumMember.tbtitle.model.res;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.cache.a;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.squareup.wire.Wire;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes7.dex */
public class GetLevelInfoHttpResponsedMessage extends HttpResponsedMessage {
    private DataRes mResult;

    public GetLevelInfoHttpResponsedMessage(int i) {
        super(i);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
        if (getLevelInfoResIdl.error != null) {
            setError(getLevelInfoResIdl.error.errorno.intValue());
            setErrorString(getLevelInfoResIdl.error.usermsg);
        }
        if (getError() == 0 && getLevelInfoResIdl.data != null) {
            this.mResult = getLevelInfoResIdl.data;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            getLevelInfoRequestMessage = (GetLevelInfoRequestMessage) getOrginalMessage().getExtra();
        }
        if (getLevelInfoRequestMessage != null) {
            new a().l(getLevelInfoRequestMessage.getForumId() + "", bArr);
        }
    }
}
