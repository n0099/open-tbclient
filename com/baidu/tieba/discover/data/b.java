package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.util.j;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements i {
    private long aBU;

    public void M(long j) {
        this.aBU = j;
    }

    public long Gb() {
        return this.aBU;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object V(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aBU);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        j.a(builder2.data, true);
        return builder2.build(false);
    }
}
