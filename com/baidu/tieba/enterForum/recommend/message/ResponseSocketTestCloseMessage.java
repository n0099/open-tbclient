package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.TestClose.TestCloseResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketTestCloseMessage extends SocketResponsedMessage {
    public ResponseSocketTestCloseMessage() {
        super(309633);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        TestCloseResIdl testCloseResIdl = (TestCloseResIdl) new Wire(new Class[0]).parseFrom(bArr, TestCloseResIdl.class);
        if (testCloseResIdl == null) {
            return;
        }
        setError(testCloseResIdl.error.errorno.intValue());
        setErrorString(testCloseResIdl.error.usermsg);
    }
}
