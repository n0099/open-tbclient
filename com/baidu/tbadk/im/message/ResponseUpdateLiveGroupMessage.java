package com.baidu.tbadk.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateLiveGroup.UpdateLiveGroupResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateLiveGroupMessage extends SocketResponsedMessage {
    public ResponseUpdateLiveGroupMessage() {
        super(107102);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateLiveGroupResIdl updateLiveGroupResIdl = (UpdateLiveGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateLiveGroupResIdl.class);
        setError(updateLiveGroupResIdl.error.errorno.intValue());
        setErrorString(updateLiveGroupResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
