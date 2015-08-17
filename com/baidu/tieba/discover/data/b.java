package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.g;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long aLD;

    public void P(long j) {
        this.aLD = j;
    }

    public long Ia() {
        return this.aLD;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aLD);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        g.a(builder2.data, true);
        return builder2.build(false);
    }
}
