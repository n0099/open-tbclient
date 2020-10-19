package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.u;
import tbclient.ElectionInfo.DataReq;
import tbclient.ElectionInfo.ElectionInfoReqIdl;
/* loaded from: classes21.dex */
public class VoteElectionRequestMessage extends NetMessage {
    private long fid;
    private int pn;
    private int rn;

    public VoteElectionRequestMessage() {
        super(CmdConfigHttp.CMD_BAR_ELECTION, 309642);
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.fid = Long.valueOf(this.fid);
        builder.rn = Integer.valueOf(this.rn);
        builder.pn = Integer.valueOf(this.pn);
        u.a(builder, false);
        ElectionInfoReqIdl.Builder builder2 = new ElectionInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
