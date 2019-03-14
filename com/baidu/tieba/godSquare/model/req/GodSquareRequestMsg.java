package com.baidu.tieba.godSquare.model.req;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.GetHotGod.DataReq;
import tbclient.GetHotGod.GetHotGodReqIdl;
/* loaded from: classes6.dex */
public class GodSquareRequestMsg extends NetMessage {
    private static final int rn = 30;
    public int pn;

    public GodSquareRequestMsg() {
        super(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = 30;
        if (z) {
            s.bindCommonParamsToProtobufData(builder, true);
        }
        GetHotGodReqIdl.Builder builder2 = new GetHotGodReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
