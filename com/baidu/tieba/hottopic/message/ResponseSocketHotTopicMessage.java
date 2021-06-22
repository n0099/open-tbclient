package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.d1.c.e;
import tbclient.Hottopic.HottopicResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketHotTopicMessage extends SocketResponsedMessage {
    public e topicData;

    public ResponseSocketHotTopicMessage() {
        super(303050);
        this.topicData = null;
    }

    public e getHotTopicData() {
        return this.topicData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        super.afterDispatchInBackGround(i2, (int) bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        HottopicResIdl hottopicResIdl = (HottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, HottopicResIdl.class);
        if (hottopicResIdl != null) {
            setError(hottopicResIdl.error.errorno.intValue());
            setErrorString(hottopicResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            Object extra = getOrginalMessage().getExtra();
            Integer num = extra instanceof Integer ? (Integer) extra : null;
            e eVar = new e();
            this.topicData = eVar;
            if (num != null) {
                eVar.s = num.intValue();
            }
            this.topicData.o(hottopicResIdl.data);
        }
    }
}
