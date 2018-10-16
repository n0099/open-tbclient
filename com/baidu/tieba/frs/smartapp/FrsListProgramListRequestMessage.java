package com.baidu.tieba.frs.smartapp;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import tbclient.SmartAppList.DataReq;
import tbclient.SmartAppList.SmartAppListReqIdl;
/* loaded from: classes6.dex */
public class FrsListProgramListRequestMessage extends NetMessage {
    private long fid;
    private int pn;
    private String rn;

    public FrsListProgramListRequestMessage() {
        super(CmdConfigHttp.CMD_HTTP_SMART_APP, 309623);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(String str) {
        this.rn = str;
    }

    public void setForumId(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.fid = Long.valueOf(getFid());
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = this.rn;
        if (z) {
            p.bindCommonParamsToProtobufData(builder, true);
        }
        SmartAppListReqIdl.Builder builder2 = new SmartAppListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
