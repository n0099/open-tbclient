package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long atw;

    public void H(long j) {
        this.atw = j;
    }

    public long CN() {
        return this.atw;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> kQ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object X(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.atw);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.h.a(builder2.data, true);
        return builder2.build(false);
    }
}
