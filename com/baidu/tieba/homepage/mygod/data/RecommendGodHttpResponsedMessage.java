package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class RecommendGodHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, GodFeedResIdl> {
    public RecommendGodHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FRS_GOD);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<GodFeedResIdl> getProtobufResponseIdlClass() {
        return GodFeedResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> M;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof e) {
                e eVar = (e) mvcNetMessage.getRequestData();
                if (eVar.getPn() == 1 && (M = com.baidu.tbadk.core.b.a.tm().M("RecommendGodCache", TbadkCoreApplication.getCurrentAccount())) != null) {
                    M.k(new StringBuilder(String.valueOf(eVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
