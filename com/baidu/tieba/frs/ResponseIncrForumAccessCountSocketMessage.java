package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.IncrForumAccessCount.IncrForumAccessCountResIdl;
/* loaded from: classes2.dex */
public class ResponseIncrForumAccessCountSocketMessage extends SocketResponsedMessage {
    private IncrForumAccessCountResIdl mResponseData;

    public ResponseIncrForumAccessCountSocketMessage() {
        super(309360);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.mResponseData = (IncrForumAccessCountResIdl) new Wire(new Class[0]).parseFrom(bArr, IncrForumAccessCountResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
