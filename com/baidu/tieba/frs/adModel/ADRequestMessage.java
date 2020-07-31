package com.baidu.tieba.frs.adModel;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.util.t;
import tbclient.GetADList.DataReq;
import tbclient.GetADList.GetADListReqIdl;
/* loaded from: classes16.dex */
public class ADRequestMessage extends NetMessage {
    private long fid;
    private long offset;
    private int rn;

    public ADRequestMessage() {
        super(1003411, 309611);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.offset = Long.valueOf(this.offset);
        builder.fid = Long.valueOf(this.fid);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            t.a(builder, true);
        }
        GetADListReqIdl.Builder builder2 = new GetADListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public long getOffset() {
        return this.offset;
    }
}
