package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Realtime.RealtimeResIdl;
/* loaded from: classes.dex */
public class RealTimeSocketResponse extends SocketResponsedMessage {
    public RealTimeSocketResponse() {
        super(309277);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        RealtimeResIdl realtimeResIdl = (RealtimeResIdl) new Wire(new Class[0]).parseFrom(bArr, RealtimeResIdl.class);
        if (realtimeResIdl != null && realtimeResIdl.error != null) {
            if (realtimeResIdl.error.errorno != null) {
                setError(realtimeResIdl.error.errorno.intValue());
            }
            setErrorString(realtimeResIdl.error.usermsg);
        }
    }
}
