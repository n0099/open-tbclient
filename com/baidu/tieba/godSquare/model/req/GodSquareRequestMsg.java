package com.baidu.tieba.godSquare.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.GetHotGod.DataReq;
import tbclient.GetHotGod.GetHotGodReqIdl;
/* loaded from: classes.dex */
public class GodSquareRequestMsg extends NetMessage {
    public int pn;
    private final int rn;

    public GodSquareRequestMsg() {
        super(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
        this.rn = 30;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = 30;
        if (z) {
            o.a(builder, true);
        }
        GetHotGodReqIdl.Builder builder2 = new GetHotGodReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
