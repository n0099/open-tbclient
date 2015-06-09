package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.util.j;
import java.util.HashMap;
import tbclient.FoundNew.DataReq;
import tbclient.FoundNew.FoundNewReqIdl;
/* loaded from: classes.dex */
public class b implements i {
    private long aEe;

    public void N(long j) {
        this.aEe = j;
    }

    public long Hl() {
        return this.aEe;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oS() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object Y(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = Long.valueOf(this.aEe);
        FoundNewReqIdl.Builder builder2 = new FoundNewReqIdl.Builder();
        builder2.data = builder.build(false);
        j.a(builder2.data, true);
        return builder2.build(false);
    }
}
