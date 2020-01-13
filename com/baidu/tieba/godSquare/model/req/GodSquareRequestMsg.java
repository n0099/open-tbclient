package com.baidu.tieba.godSquare.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetHotGod.DataReq;
import tbclient.GetHotGod.GetHotGodReqIdl;
/* loaded from: classes9.dex */
public class GodSquareRequestMsg extends NetMessage {
    private static final int rn = 30;
    public int pn;

    public GodSquareRequestMsg() {
        super(1003099, CmdConfigSocket.CMD_GET_HOT_GOD);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = 30;
        if (z) {
            t.a(builder, true);
        }
        GetHotGodReqIdl.Builder builder2 = new GetHotGodReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
