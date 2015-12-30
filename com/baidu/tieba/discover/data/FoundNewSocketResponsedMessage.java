package com.baidu.tieba.discover.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FoundNew.FoundNewResIdl;
/* loaded from: classes.dex */
public class FoundNewSocketResponsedMessage extends MvcSocketResponsedMessage<a, FoundNewResIdl> {
    public FoundNewSocketResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<FoundNewResIdl> getProtobufResponseIdlClass() {
        return FoundNewResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> cB;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if ((mvcNetMessage.getRequestData() instanceof b) && getData().Jl() > ((b) mvcNetMessage.getRequestData()).Jl() && (cB = com.baidu.tbadk.core.b.a.tc().cB("FoundNewCache")) != null) {
                cB.f("FoundNewData", bArr);
            }
        }
    }
}
