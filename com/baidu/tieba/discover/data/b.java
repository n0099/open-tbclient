package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long aKI;

    public void Z(long j) {
        this.aKI = j;
    }

    public long HI() {
        return this.aKI;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oX() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aKI);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.h.a(builder2.data, true);
        return builder2.build(false);
    }
}
