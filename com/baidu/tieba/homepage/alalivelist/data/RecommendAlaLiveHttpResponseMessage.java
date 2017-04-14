package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.AlaTab.AlaTabResIdl;
/* loaded from: classes.dex */
public class RecommendAlaLiveHttpResponseMessage extends MvcProtobufHttpResponsedMessage<c, AlaTabResIdl> {
    public RecommendAlaLiveHttpResponseMessage() {
        super(CmdConfigHttp.CMD_ALA_LIVE_LIST);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<AlaTabResIdl> getProtobufResponseIdlClass() {
        return AlaTabResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if ((getOrginalMessage().getExtra() instanceof MvcNetMessage) && (((MvcNetMessage) getOrginalMessage().getExtra()).getRequestData() instanceof b)) {
            com.baidu.tbadk.ala.a.nZ().putLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis());
        }
    }
}
