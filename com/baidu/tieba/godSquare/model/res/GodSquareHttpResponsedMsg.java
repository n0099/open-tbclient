package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.godSquare.model.a;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.squareup.wire.Wire;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes11.dex */
public class GodSquareHttpResponsedMsg extends HttpResponsedMessage {
    private boolean hasMore;
    private DataRes mResult;

    public GodSquareHttpResponsedMsg() {
        super(1003099);
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetHotGodResIdl getHotGodResIdl = (GetHotGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGodResIdl.class);
        if (getHotGodResIdl.error != null) {
            setError(getHotGodResIdl.error.errorno.intValue());
            setErrorString(getHotGodResIdl.error.usermsg);
        }
        if (getError() == 0 && getHotGodResIdl.data != null) {
            this.mResult = getHotGodResIdl.data;
            this.hasMore = getHotGodResIdl.data.has_more.intValue() != 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof GodSquareRequestMsg)) {
            GodSquareRequestMsg godSquareRequestMsg = (GodSquareRequestMsg) getOrginalMessage().getExtra();
            if (godSquareRequestMsg.pn == 1) {
                new a().l(godSquareRequestMsg.pn + "", bArr);
            }
        }
    }
}
