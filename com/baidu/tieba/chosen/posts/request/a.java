package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes22.dex */
public class a implements e, h {
    private int requestCount;

    public void cgc() {
        this.requestCount++;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> buw() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> bux() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object jx(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.requestCount);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        u.a(builder2.data, true);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String but() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean buu() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
