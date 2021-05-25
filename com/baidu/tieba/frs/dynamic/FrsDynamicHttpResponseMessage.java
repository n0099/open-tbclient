package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import d.a.n0.r0.m1.a;
import tbclient.Error;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes4.dex */
public class FrsDynamicHttpResponseMessage extends MvcProtobufHttpResponsedMessage<a, StarTrendsResIdl> {
    public a responseData;

    public FrsDynamicHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_DYNAMIC);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        a aVar = new a();
        this.responseData = aVar;
        StarTrendsResIdl a2 = aVar.a(bArr);
        if (a2 != null && (error = a2.error) != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
                this.responseData.f58897h = a2.error.errorno.intValue();
            }
            setErrorString(a2.error.usermsg);
        }
        setData(this.responseData);
    }
}
