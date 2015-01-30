package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.k;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long auv;

    public void H(long j) {
        this.auv = j;
    }

    public long Dm() {
        return this.auv;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> kQ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object X(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.auv);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        k.a(builder2.data, true);
        return builder2.build(false);
    }
}
