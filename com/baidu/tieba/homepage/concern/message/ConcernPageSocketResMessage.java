package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserlikeResIdl;
/* loaded from: classes4.dex */
public class ConcernPageSocketResMessage extends SocketResponsedMessage {
    public DataRes resultData;

    public ConcernPageSocketResMessage() {
        super(309474);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        UserlikeResIdl userlikeResIdl = (UserlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UserlikeResIdl.class);
        if (userlikeResIdl != null) {
            Error error = userlikeResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(userlikeResIdl.error.errmsg);
            }
            DataRes dataRes = userlikeResIdl.data;
            if (dataRes != null) {
                this.resultData = dataRes;
            }
        }
    }
}
