package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.g;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long aLQ;

    public void Q(long j) {
        this.aLQ = j;
    }

    public long HO() {
        return this.aLQ;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oW() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aLQ);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        g.a(builder2.data, true);
        return builder2.build(false);
    }
}
