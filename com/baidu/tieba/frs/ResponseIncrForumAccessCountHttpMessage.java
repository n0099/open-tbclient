package com.baidu.tieba.frs;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.IncrForumAccessCount.IncrForumAccessCountResIdl;
/* loaded from: classes4.dex */
public class ResponseIncrForumAccessCountHttpMessage extends TbHttpResponsedMessage {
    public IncrForumAccessCountResIdl mResponseData;

    public ResponseIncrForumAccessCountHttpMessage() {
        super(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        IncrForumAccessCountResIdl incrForumAccessCountResIdl = (IncrForumAccessCountResIdl) new Wire(new Class[0]).parseFrom(bArr, IncrForumAccessCountResIdl.class);
        this.mResponseData = incrForumAccessCountResIdl;
        Error error = incrForumAccessCountResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
