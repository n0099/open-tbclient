package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SubscribeLiveGroup.SubscribeLiveGroupResIdl;
/* loaded from: classes.dex */
public class ResponseSubscribeLiveGroupMessage extends SocketResponsedMessage {
    public ResponseSubscribeLiveGroupMessage() {
        super(107105);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        SubscribeLiveGroupResIdl subscribeLiveGroupResIdl = (SubscribeLiveGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, SubscribeLiveGroupResIdl.class);
        setError(subscribeLiveGroupResIdl.error.errorno.intValue());
        setErrorString(subscribeLiveGroupResIdl.error.usermsg);
    }
}
