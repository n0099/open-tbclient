package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.o;
import java.util.HashMap;
import tbclient.AlaTab.AlaTabReqIdl;
import tbclient.AlaTab.DataReq;
/* loaded from: classes.dex */
public class a implements h {
    private int pn;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> En() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bQ(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(getPn());
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        AlaTabReqIdl.Builder builder2 = new AlaTabReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }
}
