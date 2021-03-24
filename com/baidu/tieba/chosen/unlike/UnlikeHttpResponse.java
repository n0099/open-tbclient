package com.baidu.tieba.chosen.unlike;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Unlike.DataRes;
import tbclient.Unlike.UnlikeResIdl;
/* loaded from: classes4.dex */
public class UnlikeHttpResponse extends HttpResponsedMessage {
    public long threadId;

    public UnlikeHttpResponse() {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE);
    }

    public long getThreadId() {
        return this.threadId;
    }

    public UnlikeHttpResponse(int i) {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Long l;
        UnlikeResIdl unlikeResIdl = (UnlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UnlikeResIdl.class);
        setError(unlikeResIdl.error.errorno.intValue());
        setErrorString(unlikeResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = unlikeResIdl.data) == null || (l = dataRes.thread_id) == null) {
            return;
        }
        this.threadId = l.longValue();
    }
}
