package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserlikeResIdl;
/* loaded from: classes16.dex */
public class ConcernPageHttpResMessage extends HttpResponsedMessage {
    private DataRes resultData;

    public ConcernPageHttpResMessage() {
        super(1003343);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserlikeResIdl userlikeResIdl = (UserlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UserlikeResIdl.class);
        if (userlikeResIdl != null) {
            if (userlikeResIdl.error != null) {
                setError(userlikeResIdl.error.errorno.intValue());
                setErrorString(userlikeResIdl.error.errmsg);
            }
            this.resultData = userlikeResIdl.data;
        }
    }

    public DataRes getResultData() {
        return this.resultData;
    }
}
