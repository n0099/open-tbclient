package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.squareup.wire.Wire;
import tbclient.GetInfluenceRank.GetInfluenceRankResIdl;
/* loaded from: classes21.dex */
public class HotUserRankHttpResMsg extends HttpResponsedMessage {
    private c pageData;

    public HotUserRankHttpResMsg() {
        super(CmdConfigHttp.CMD_HOT_USER_RANK);
    }

    public c getPageData() {
        return this.pageData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetInfluenceRankResIdl getInfluenceRankResIdl = (GetInfluenceRankResIdl) new Wire(new Class[0]).parseFrom(bArr, GetInfluenceRankResIdl.class);
        if (getInfluenceRankResIdl != null) {
            if (getInfluenceRankResIdl.error != null) {
                if (getInfluenceRankResIdl.error.errorno != null) {
                    setError(getInfluenceRankResIdl.error.errorno.intValue());
                }
                setErrorString(getInfluenceRankResIdl.error.usermsg);
            }
            this.pageData = new c();
            this.pageData.a(getInfluenceRankResIdl.data);
        }
    }
}
