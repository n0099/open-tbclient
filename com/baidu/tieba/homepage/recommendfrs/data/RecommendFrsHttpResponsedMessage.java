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
        o<byte[]> cB;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof d) {
                d dVar = (d) mvcNetMessage.getRequestData();
                if (dVar.apc() == 0 && (cB = com.baidu.tbadk.core.b.a.tm().cB("RecommendFrsCache")) != null) {
                    cB.k(new StringBuilder(String.valueOf(dVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
