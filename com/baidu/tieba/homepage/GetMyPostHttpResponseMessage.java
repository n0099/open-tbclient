package com.baidu.tieba.homepage;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class GetMyPostHttpResponseMessage extends TbHttpResponsedMessage {
    public GetMyPostResIdl mResponseData;

    public GetMyPostHttpResponseMessage(int i) {
        super(CmdConfigHttp.CMD_GET_MY_POST);
    }

    public GetMyPostResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        GetMyPostResIdl getMyPostResIdl = (GetMyPostResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyPostResIdl.class);
        this.mResponseData = getMyPostResIdl;
        Error error = getMyPostResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
