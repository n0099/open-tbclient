package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class GetMyPostSocketResponseMessage extends SocketResponsedMessage {
    public GetMyPostResIdl mResponseData;

    public GetMyPostSocketResponseMessage() {
        super(303111);
    }

    public GetMyPostResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMyPostResIdl getMyPostResIdl = (GetMyPostResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyPostResIdl.class);
        this.mResponseData = getMyPostResIdl;
        Error error = getMyPostResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
