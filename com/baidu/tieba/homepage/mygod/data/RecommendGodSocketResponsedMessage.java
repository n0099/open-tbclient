package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class RecommendGodSocketResponsedMessage extends MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, GodFeedResIdl> {
    public RecommendGodSocketResponsedMessage() {
        super(309281);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<GodFeedResIdl> getProtobufResponseIdlClass() {
        return GodFeedResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> M;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof d) {
                d dVar = (d) mvcNetMessage.getRequestData();
                if (dVar.getPn() == 1 && (M = com.baidu.tbadk.core.b.a.rP().M("RecommendGodCache", TbadkCoreApplication.getCurrentAccount())) != null) {
                    M.e(new StringBuilder(String.valueOf(dVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
