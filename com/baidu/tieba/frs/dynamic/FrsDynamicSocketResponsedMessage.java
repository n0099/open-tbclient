package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes6.dex */
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
        StarTrendsResIdl K = this.responseData.K(bArr);
        if (K != null && K.error != null) {
            if (K.error.errorno != null) {
                setError(K.error.errorno.intValue());
                this.responseData.dHx = K.error.errorno.intValue();
            }
            setErrorString(K.error.usermsg);
        }
        setData(this.responseData);
    }
}
