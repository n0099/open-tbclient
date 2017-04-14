package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.AlaTab.AlaTabResIdl;
/* loaded from: classes.dex */
public class RecommendAlaLiveSocketResponseMessage extends MvcSocketResponsedMessage<c, AlaTabResIdl> {
    public RecommendAlaLiveSocketResponseMessage() {
        super(309431);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<AlaTabResIdl> getProtobufResponseIdlClass() {
        return AlaTabResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if ((getOrginalMessage().getExtra() instanceof MvcNetMessage) && (((MvcNetMessage) getOrginalMessage().getExtra()).getRequestData() instanceof b)) {
            com.baidu.tbadk.ala.a.nZ().putLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis());
        }
    }
}
