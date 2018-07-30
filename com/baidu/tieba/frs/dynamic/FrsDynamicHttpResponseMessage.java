package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes2.dex */
public class FrsDynamicHttpResponseMessage extends MvcProtobufHttpResponsedMessage<b, StarTrendsResIdl> {
    public b responseData;

    public FrsDynamicHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_DYNAMIC);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new b();
        StarTrendsResIdl B = this.responseData.B(bArr);
        if (B != null && B.error != null) {
            if (B.error.errorno != null) {
                setError(B.error.errorno.intValue());
                this.responseData.dsU = B.error.errorno.intValue();
            }
            setErrorString(B.error.usermsg);
        }
        setData(this.responseData);
    }
}
