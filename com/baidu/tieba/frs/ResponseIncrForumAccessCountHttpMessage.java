package com.baidu.tieba.frs;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.IncrForumAccessCount.IncrForumAccessCountResIdl;
/* loaded from: classes6.dex */
public class ResponseIncrForumAccessCountHttpMessage extends TbHttpResponsedMessage {
    private IncrForumAccessCountResIdl mResponseData;

    public ResponseIncrForumAccessCountHttpMessage() {
        super(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (IncrForumAccessCountResIdl) new Wire(new Class[0]).parseFrom(bArr, IncrForumAccessCountResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
