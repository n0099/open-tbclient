package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.s;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes5.dex */
public class a implements e, h {
    private int requestCount;

    public void aRV() {
        this.requestCount++;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> anY() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> anZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object eW(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.requestCount);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        s.bindCommonParamsToProtobufData(builder2.data, true);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String anV() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean anW() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
