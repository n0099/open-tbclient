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
        o<byte[]> cq;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if ((mvcNetMessage.getRequestData() instanceof b) && ((a) getData()).HE() > ((b) mvcNetMessage.getRequestData()).HE() && (cq = com.baidu.tbadk.core.b.a.sL().cq("FoundNewCache")) != null) {
                cq.f("FoundNewData", bArr);
            }
        }
    }
}
