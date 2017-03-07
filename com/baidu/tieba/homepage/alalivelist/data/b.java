package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.n;
import java.util.HashMap;
import tbclient.AlaTab.AlaTabReqIdl;
import tbclient.AlaTab.DataReq;
/* loaded from: classes.dex */
public class b implements h {
    private int pn;
    private long tagCode;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> EL() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bN(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(getPn());
        if (z) {
            n.bindCommonParamsToProtobufData(builder, true);
        }
        AlaTabReqIdl.Builder builder2 = new AlaTabReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public long getTagCode() {
        return this.tagCode;
    }
}
