package com.baidu.tieba.discover.data;

import com.baidu.adp.lib.cache.t;
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
        t<byte[]> bW;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if ((mvcNetMessage.getRequestData() instanceof b) && ((a) getData()).Gh() > ((b) mvcNetMessage.getRequestData()).Gh() && (bW = com.baidu.tbadk.core.b.a.rc().bW("FoundNewCache")) != null) {
                bW.f("FoundNewData", bArr);
            }
        }
    }
}
