package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes16.dex */
public class FrsDynamicHttpResponseMessage extends MvcProtobufHttpResponsedMessage<a, StarTrendsResIdl> {
    public a responseData;

    public FrsDynamicHttpResponseMessage() {
        super(1003398);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new a();
        StarTrendsResIdl af = this.responseData.af(bArr);
        if (af != null && af.error != null) {
            if (af.error.errorno != null) {
                setError(af.error.errorno.intValue());
                this.responseData.mErrorNo = af.error.errorno.intValue();
            }
            setErrorString(af.error.usermsg);
        }
        setData(this.responseData);
    }
}
