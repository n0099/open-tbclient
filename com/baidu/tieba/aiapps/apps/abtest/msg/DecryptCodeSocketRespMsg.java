package com.baidu.tieba.aiapps.apps.abtest.msg;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.decrypt.DecryptCodeResIdl;
/* loaded from: classes4.dex */
public class DecryptCodeSocketRespMsg extends SocketResponsedMessage {
    private a decryptData;

    public DecryptCodeSocketRespMsg(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        try {
            DecryptCodeResIdl decryptCodeResIdl = (DecryptCodeResIdl) new Wire(new Class[0]).parseFrom(bArr, DecryptCodeResIdl.class);
            if (decryptCodeResIdl != null) {
                this.decryptData = new a();
                this.decryptData.a(decryptCodeResIdl.data);
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public a getDecryptData() {
        return this.decryptData;
    }
}
