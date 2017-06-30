package com.baidu.tieba.homepage;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class GetMyPostHttpResponseMessage extends TbHttpResponsedMessage {
    private GetMyPostResIdl mResponseData;

    public GetMyPostHttpResponseMessage(int i) {
        super(CmdConfigHttp.CMD_GET_MY_POST);
    }

    public GetMyPostResIdl getResponseData() {
        return this.mResponseData;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (GetMyPostResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyPostResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
