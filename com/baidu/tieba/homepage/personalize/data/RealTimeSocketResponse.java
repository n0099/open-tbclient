package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Realtime.RealtimeResIdl;
/* loaded from: classes4.dex */
public class RealTimeSocketResponse extends SocketResponsedMessage {
    public RealTimeSocketResponse() {
        super(309277);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        RealtimeResIdl realtimeResIdl = (RealtimeResIdl) new Wire(new Class[0]).parseFrom(bArr, RealtimeResIdl.class);
        if (realtimeResIdl == null || (error = realtimeResIdl.error) == null) {
            return;
        }
        Integer num = error.errorno;
        if (num != null) {
            setError(num.intValue());
        }
        setErrorString(realtimeResIdl.error.usermsg);
    }
}
