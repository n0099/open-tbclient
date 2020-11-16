package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.TestClose.TestCloseResIdl;
/* loaded from: classes21.dex */
public class ResponseHttpTestCloseMessage extends TbHttpResponsedMessage {
    public ResponseHttpTestCloseMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        TestCloseResIdl testCloseResIdl = (TestCloseResIdl) new Wire(new Class[0]).parseFrom(bArr, TestCloseResIdl.class);
        if (testCloseResIdl != null) {
            setError(testCloseResIdl.error.errorno.intValue());
            setErrorString(testCloseResIdl.error.usermsg);
        }
    }
}
