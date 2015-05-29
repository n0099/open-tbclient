package com.baidu.tieba.chosen.unlike;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Unlike.UnlikeResIdl;
/* loaded from: classes.dex */
public class UnlikeHttpResponse extends HttpResponsedMessage {
    private long threadId;

    public UnlikeHttpResponse() {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE);
    }

    public UnlikeHttpResponse(int i) {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE);
    }

    public long getThreadId() {
        return this.threadId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UnlikeResIdl unlikeResIdl = (UnlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UnlikeResIdl.class);
        setError(unlikeResIdl.error.errorno.intValue());
        setErrorString(unlikeResIdl.error.usermsg);
        if (getError() == 0 && unlikeResIdl.data != null && unlikeResIdl.data.thread_id != null) {
            this.threadId = unlikeResIdl.data.thread_id.longValue();
        }
    }
}
