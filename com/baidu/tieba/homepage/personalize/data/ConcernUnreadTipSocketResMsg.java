package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.b1.g.j.e;
import tbclient.Error;
import tbclient.UnreadTip.UnreadTipResIdl;
/* loaded from: classes4.dex */
public class ConcernUnreadTipSocketResMsg extends SocketResponsedMessage {
    public e mData;

    public ConcernUnreadTipSocketResMsg() {
        super(309541);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        UnreadTipResIdl unreadTipResIdl = (UnreadTipResIdl) new Wire(new Class[0]).parseFrom(bArr, UnreadTipResIdl.class);
        if (unreadTipResIdl != null) {
            Error error = unreadTipResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(unreadTipResIdl.error.errmsg);
            }
            if (unreadTipResIdl.data != null) {
                e eVar = new e();
                this.mData = eVar;
                eVar.b(unreadTipResIdl.data);
            }
        }
    }
}
