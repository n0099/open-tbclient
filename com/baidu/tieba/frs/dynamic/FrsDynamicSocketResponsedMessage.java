package com.baidu.tieba.frs.dynamic;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes4.dex */
public class FrsDynamicSocketResponsedMessage extends MvcSocketResponsedMessage<a, StarTrendsResIdl> {
    public a responseData;

    public FrsDynamicSocketResponsedMessage() {
        super(CmdConfigSocket.CMD_FRS_DYNAMIC);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        return StarTrendsResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new a();
        StarTrendsResIdl D = this.responseData.D(bArr);
        if (D != null && D.error != null) {
            if (D.error.errorno != null) {
                setError(D.error.errorno.intValue());
                this.responseData.mErrorNo = D.error.errorno.intValue();
            }
            setErrorString(D.error.usermsg);
        }
        setData(this.responseData);
    }
}
