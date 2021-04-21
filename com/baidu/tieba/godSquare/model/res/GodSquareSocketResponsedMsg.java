package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.squareup.wire.Wire;
import d.b.j0.v0.c.a;
import tbclient.Error;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes4.dex */
public class GodSquareSocketResponsedMsg extends SocketResponsedMessage {
    public boolean hasMore;
    public DataRes mResult;

    public GodSquareSocketResponsedMsg() {
        super(309315);
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof GodSquareRequestMsg)) {
            return;
        }
        GodSquareRequestMsg godSquareRequestMsg = (GodSquareRequestMsg) getOrginalMessage().getExtra();
        if (godSquareRequestMsg.pn == 1) {
            a aVar = new a();
            aVar.c(godSquareRequestMsg.pn + "", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetHotGodResIdl getHotGodResIdl = (GetHotGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGodResIdl.class);
        Error error = getHotGodResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getHotGodResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = getHotGodResIdl.data) != null) {
            this.mResult = dataRes;
            this.hasMore = dataRes.has_more.intValue() != 0;
        }
    }
}
