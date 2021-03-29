package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserlikeResIdl;
/* loaded from: classes3.dex */
public class ConcernPageHttpResMessage extends HttpResponsedMessage {
    public DataRes resultData;

    public ConcernPageHttpResMessage() {
        super(CmdConfigHttp.CMD_CONCERN_PAGE);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserlikeResIdl userlikeResIdl = (UserlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UserlikeResIdl.class);
        if (userlikeResIdl != null) {
            Error error = userlikeResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(userlikeResIdl.error.errmsg);
            }
            this.resultData = userlikeResIdl.data;
        }
    }
}
