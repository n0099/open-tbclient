package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetCommonForumState.SetCommonForumStateResIdl;
/* loaded from: classes4.dex */
public class ResponseSetCommForumStateSocketMessage extends SocketResponsedMessage {
    public SetCommonForumStateResIdl mResponseData;

    public ResponseSetCommForumStateSocketMessage() {
        super(309365);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SetCommonForumStateResIdl setCommonForumStateResIdl = (SetCommonForumStateResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCommonForumStateResIdl.class);
        this.mResponseData = setCommonForumStateResIdl;
        Error error = setCommonForumStateResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
