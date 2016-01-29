package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.KillAd.KillAdResIdl;
/* loaded from: classes.dex */
public class SubmitCloseSocketResponseMessage extends SocketResponsedMessage {
    public SubmitCloseSocketResponseMessage() {
        super(309266);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        KillAdResIdl killAdResIdl = (KillAdResIdl) new Wire(new Class[0]).parseFrom(bArr, KillAdResIdl.class);
        if (killAdResIdl != null) {
            setError(killAdResIdl.error.errorno.intValue());
            setErrorString(killAdResIdl.error.usermsg);
        }
        if (getError() != 0) {
        }
    }
}
