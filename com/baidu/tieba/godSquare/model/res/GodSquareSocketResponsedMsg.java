package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.godSquare.model.a;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.squareup.wire.Wire;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes8.dex */
public class GodSquareSocketResponsedMsg extends SocketResponsedMessage {
    private boolean hasMore;
    private DataRes mResult;

    public boolean getHasMore() {
        return this.hasMore;
    }

    public DataRes getResult() {
        return this.mResult;
    }

    public GodSquareSocketResponsedMsg() {
        super(CmdConfigSocket.CMD_GET_HOT_GOD);
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
