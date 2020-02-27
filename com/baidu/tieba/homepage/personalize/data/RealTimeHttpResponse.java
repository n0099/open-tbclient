package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Realtime.RealtimeResIdl;
/* loaded from: classes9.dex */
public class RealTimeHttpResponse extends HttpResponsedMessage {
    public RealTimeHttpResponse() {
        super(1003072);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RealtimeResIdl realtimeResIdl = (RealtimeResIdl) new Wire(new Class[0]).parseFrom(bArr, RealtimeResIdl.class);
        if (realtimeResIdl != null && realtimeResIdl.error != null) {
            if (realtimeResIdl.error.errorno != null) {
                setError(realtimeResIdl.error.errorno.intValue());
            }
            setErrorString(realtimeResIdl.error.usermsg);
        }
    }
}
