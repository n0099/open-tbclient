package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes4.dex */
public class FrsDynamicSocketResponsedMessage extends MvcSocketResponsedMessage<a, StarTrendsResIdl> {
    public a responseData;

    public FrsDynamicSocketResponsedMessage() {
        super(309602);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new a();
        StarTrendsResIdl Q = this.responseData.Q(bArr);
        if (Q != null && Q.error != null) {
            if (Q.error.errorno != null) {
                setError(Q.error.errorno.intValue());
                this.responseData.mErrorNo = Q.error.errorno.intValue();
            }
            setErrorString(Q.error.usermsg);
        }
        setData(this.responseData);
    }
}
