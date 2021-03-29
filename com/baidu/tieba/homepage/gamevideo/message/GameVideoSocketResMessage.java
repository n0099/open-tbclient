package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.RecomVerticalResIdl;
/* loaded from: classes3.dex */
public class GameVideoSocketResMessage extends SocketResponsedMessage {
    public DataRes mResultData;

    public GameVideoSocketResMessage() {
        super(309646);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecomVerticalResIdl recomVerticalResIdl = (RecomVerticalResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVerticalResIdl.class);
        if (recomVerticalResIdl != null) {
            Error error = recomVerticalResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(recomVerticalResIdl.error.errmsg);
            }
            this.mResultData = recomVerticalResIdl.data;
        }
    }
}
