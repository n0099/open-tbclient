package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Realtime.RealtimeResIdl;
/* loaded from: classes3.dex */
public class RealTimeHttpResponse extends HttpResponsedMessage {
    public RealTimeHttpResponse() {
        super(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
