package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.j0.i.c.c;
import tbclient.Error;
import tbclient.GetInfluenceRank.GetInfluenceRankResIdl;
/* loaded from: classes4.dex */
public class HotUserRankSocketResMsg extends SocketResponsedMessage {
    public c pageData;

    public HotUserRankSocketResMsg() {
        super(309652);
    }

    public c getPageData() {
        return this.pageData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetInfluenceRankResIdl getInfluenceRankResIdl = (GetInfluenceRankResIdl) new Wire(new Class[0]).parseFrom(bArr, GetInfluenceRankResIdl.class);
        if (getInfluenceRankResIdl == null) {
            return;
        }
        Error error = getInfluenceRankResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getInfluenceRankResIdl.error.usermsg);
        }
        c cVar = new c();
        this.pageData = cVar;
        cVar.c(getInfluenceRankResIdl.data);
    }
}
