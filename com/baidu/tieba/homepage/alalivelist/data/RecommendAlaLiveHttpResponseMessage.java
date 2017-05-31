package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.AlaTab.AlaTabResIdl;
/* loaded from: classes.dex */
public class RecommendAlaLiveHttpResponseMessage extends MvcProtobufHttpResponsedMessage<RecommendAlaLiveResponseData, AlaTabResIdl> {
    public RecommendAlaLiveHttpResponseMessage() {
        super(CmdConfigHttp.CMD_ALA_LIVE_LIST);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<AlaTabResIdl> getProtobufResponseIdlClass() {
        return AlaTabResIdl.class;
    }
}
