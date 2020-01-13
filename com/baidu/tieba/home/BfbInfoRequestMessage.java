package com.baidu.tieba.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetUserBfbInfo.DataReq;
import tbclient.GetUserBfbInfo.GetUserBfbInfoReqIdl;
/* loaded from: classes9.dex */
public class BfbInfoRequestMessage extends NetMessage {
    public BfbInfoRequestMessage() {
        super(1003100, CmdConfigSocket.CMD_GET_BFB_INFO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.a(builder, true);
        }
        GetUserBfbInfoReqIdl.Builder builder2 = new GetUserBfbInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
