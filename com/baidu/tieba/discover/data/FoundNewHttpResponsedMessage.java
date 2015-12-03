package com.baidu.tieba.discover.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FoundNew.FoundNewResIdl;
/* loaded from: classes.dex */
public class FoundNewHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<a, FoundNewResIdl> {
    public FoundNewHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<FoundNewResIdl> getProtobufResponseIdlClass() {
        return FoundNewResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> cy;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if ((mvcNetMessage.getRequestData() instanceof b) && ((a) getData()).IU() > ((b) mvcNetMessage.getRequestData()).IU() && (cy = com.baidu.tbadk.core.b.a.ts().cy("FoundNewCache")) != null) {
                cy.f("FoundNewData", bArr);
            }
        }
    }
}
