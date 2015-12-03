package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.i;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements h {
    private long aOo;

    public void ap(long j) {
        this.aOo = j;
    }

    public long IU() {
        return this.aOo;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> pe() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aOo);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        i.a(builder2.data, true);
        return builder2.build(false);
    }
}
