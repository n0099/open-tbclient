package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import d.a.j0.q0.m1.a;
import tbclient.Error;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes4.dex */
public class FrsDynamicSocketResponsedMessage extends MvcSocketResponsedMessage<a, StarTrendsResIdl> {
    public a responseData;

    public FrsDynamicSocketResponsedMessage() {
        super(309602);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        a aVar = new a();
        this.responseData = aVar;
        StarTrendsResIdl a2 = aVar.a(bArr);
        if (a2 != null && (error = a2.error) != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
                this.responseData.f58014h = a2.error.errorno.intValue();
            }
            setErrorString(a2.error.usermsg);
        }
        setData(this.responseData);
    }
}
