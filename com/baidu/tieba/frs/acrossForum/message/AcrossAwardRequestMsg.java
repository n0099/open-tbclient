package com.baidu.tieba.frs.acrossForum.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import tbclient.Acrossaward.AcrossawardReqIdl;
import tbclient.Acrossaward.DataReq;
/* loaded from: classes.dex */
public class AcrossAwardRequestMsg extends NetMessage {
    public String awardType;

    public AcrossAwardRequestMsg() {
        super(CmdConfigHttp.CMD_ACROSS_AWARD, 309425);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.award_type = this.awardType;
        if (z) {
            n.a(builder, true);
        }
        AcrossawardReqIdl.Builder builder2 = new AcrossawardReqIdl.Builder();
        builder2.data = builder.build(true);
        return builder2.build(true);
    }
}
