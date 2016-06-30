package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetCommonForumState.SetCommonForumStateResIdl;
/* loaded from: classes.dex */
public class ResponseSetCommForumStateSocketMessage extends SocketResponsedMessage {
    private SetCommonForumStateResIdl mResponseData;

    public ResponseSetCommForumStateSocketMessage() {
        super(309365);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        this.mResponseData = (SetCommonForumStateResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCommonForumStateResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
