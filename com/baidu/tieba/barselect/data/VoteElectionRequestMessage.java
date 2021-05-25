package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.ElectionInfo.DataReq;
import tbclient.ElectionInfo.ElectionInfoReqIdl;
/* loaded from: classes4.dex */
public class VoteElectionRequestMessage extends NetMessage {
    public long fid;
    public int pn;
    public int rn;

    public VoteElectionRequestMessage() {
        super(CmdConfigHttp.CMD_BAR_ELECTION, 309642);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.fid = Long.valueOf(this.fid);
        builder.rn = Integer.valueOf(this.rn);
        builder.pn = Integer.valueOf(this.pn);
        w.a(builder, false);
        ElectionInfoReqIdl.Builder builder2 = new ElectionInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }
}
