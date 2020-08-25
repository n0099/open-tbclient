package com.baidu.tieba.homepage;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes2.dex */
public class GetMyPostHttpResponseMessage extends TbHttpResponsedMessage {
    private GetMyPostResIdl mResponseData;

    public GetMyPostHttpResponseMessage(int i) {
        super(1003010);
    }

    public GetMyPostResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (GetMyPostResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyPostResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
