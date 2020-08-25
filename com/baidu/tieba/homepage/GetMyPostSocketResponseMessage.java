package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes2.dex */
public class GetMyPostSocketResponseMessage extends SocketResponsedMessage {
    private GetMyPostResIdl mResponseData;

    public GetMyPostSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_MY_POST);
    }

    public GetMyPostResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.mResponseData = (GetMyPostResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyPostResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
