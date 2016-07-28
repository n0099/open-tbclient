package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UploadClientLog.UploadClientLogResIdl;
/* loaded from: classes.dex */
public class ResponseUploadClientLogMessage extends SocketResponsedMessage {
    public ResponseUploadClientLogMessage() {
        super(202005);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UploadClientLogResIdl uploadClientLogResIdl = (UploadClientLogResIdl) new Wire(new Class[0]).parseFrom(bArr, UploadClientLogResIdl.class);
        if (uploadClientLogResIdl != null) {
            setError(uploadClientLogResIdl.error.errorno.intValue());
            setErrorString(uploadClientLogResIdl.error.usermsg);
            if (getError() != 0) {
            }
        }
    }
}
