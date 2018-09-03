package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes2.dex */
public class FrsDynamicSocketResponsedMessage extends MvcSocketResponsedMessage<b, StarTrendsResIdl> {
    public b responseData;

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
        this.responseData = new b();
        StarTrendsResIdl B = this.responseData.B(bArr);
        if (B != null && B.error != null) {
            if (B.error.errorno != null) {
                setError(B.error.errorno.intValue());
                this.responseData.dsR = B.error.errorno.intValue();
            }
            setErrorString(B.error.usermsg);
        }
        setData(this.responseData);
    }
}
