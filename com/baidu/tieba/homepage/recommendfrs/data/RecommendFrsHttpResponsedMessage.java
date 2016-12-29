package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<c, ExcFrsPageResIdl> {
    public RecommendFrsHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<ExcFrsPageResIdl> getProtobufResponseIdlClass() {
        return ExcFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> cC;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof d) {
                d dVar = (d) mvcNetMessage.getRequestData();
                if (dVar.ajE() == 0 && (cC = com.baidu.tbadk.core.b.a.sX().cC("RecommendFrsCache")) != null) {
                    cC.k(new StringBuilder(String.valueOf(dVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
