package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.RecomVerticalResIdl;
/* loaded from: classes16.dex */
public class GameVideoSocketResMessage extends SocketResponsedMessage {
    public DataRes mResultData;

    public GameVideoSocketResMessage() {
        super(309646);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecomVerticalResIdl recomVerticalResIdl = (RecomVerticalResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVerticalResIdl.class);
        if (recomVerticalResIdl != null) {
            if (recomVerticalResIdl.error != null) {
                setError(recomVerticalResIdl.error.errorno.intValue());
                setErrorString(recomVerticalResIdl.error.errmsg);
            }
            this.mResultData = recomVerticalResIdl.data;
        }
    }
}
