package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes23.dex */
public class a implements e, h {
    private int requestCount;

    public void csV() {
        this.requestCount++;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> bEq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> bEr() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object kL(boolean z) {
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
    public String bEn() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean bEo() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
