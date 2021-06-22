package com.baidu.tieba.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetUserBfbInfo.DataReq;
import tbclient.GetUserBfbInfo.GetUserBfbInfoReqIdl;
/* loaded from: classes4.dex */
public class BfbInfoRequestMessage extends NetMessage {
    public BfbInfoRequestMessage() {
        super(CmdConfigHttp.CMD_GET_BFB_INFO, 309366);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetUserBfbInfoReqIdl.Builder builder2 = new GetUserBfbInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
