package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.MultiConcern.MultiConcernResIdl;
/* loaded from: classes4.dex */
public class MultiConcernSocketResponseMessage extends SocketResponsedMessage {
    public MultiConcernSocketResponseMessage() {
        super(309470);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        MultiConcernResIdl multiConcernResIdl;
        if (bArr != null && (multiConcernResIdl = (MultiConcernResIdl) new Wire(new Class[0]).parseFrom(bArr, MultiConcernResIdl.class)) != null) {
            if (multiConcernResIdl.error != null && multiConcernResIdl.error.errorno != null) {
                setError(multiConcernResIdl.error.errorno.intValue());
            }
            if (multiConcernResIdl.error != null && multiConcernResIdl.error.usermsg != null && multiConcernResIdl.error.usermsg.length() > 0) {
                setErrorString(multiConcernResIdl.error.usermsg);
            }
        }
    }
}
