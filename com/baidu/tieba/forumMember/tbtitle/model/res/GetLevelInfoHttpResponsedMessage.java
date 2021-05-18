package com.baidu.tieba.forumMember.tbtitle.model.res;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.squareup.wire.Wire;
import d.a.k0.o0.d.a.b.a;
import tbclient.Error;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes4.dex */
public class GetLevelInfoHttpResponsedMessage extends HttpResponsedMessage {
    public DataRes mResult;

    public GetLevelInfoHttpResponsedMessage(int i2) {
        super(i2);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = (getOrginalMessage() == null || getOrginalMessage().getExtra() == null) ? null : (GetLevelInfoRequestMessage) getOrginalMessage().getExtra();
        if (getLevelInfoRequestMessage != null) {
            a aVar = new a();
            aVar.c(getLevelInfoRequestMessage.getForumId() + "", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
        Error error = getLevelInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getLevelInfoResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = getLevelInfoResIdl.data) != null) {
            this.mResult = dataRes;
        }
    }
}
