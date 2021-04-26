package com.baidu.tieba.frs.adModel;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.GetADList.DataReq;
import tbclient.GetADList.GetADListReqIdl;
/* loaded from: classes4.dex */
public class ADRequestMessage extends NetMessage {
    public long fid;
    public long offset;
    public int rn;

    public ADRequestMessage() {
        super(CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, 309611);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.offset = Long.valueOf(this.offset);
        builder.fid = Long.valueOf(this.fid);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            w.a(builder, true);
        }
        GetADListReqIdl.Builder builder2 = new GetADListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFid() {
        return this.fid;
    }

    public long getOffset() {
        return this.offset;
    }

    public int getRn() {
        return this.rn;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setOffset(int i2) {
        this.offset = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }
}
