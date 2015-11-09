package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes.dex */
public class c implements e, h {
    private int aJg;

    public void Hk() {
        this.aJg++;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oY() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.aJg);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.h.a(builder2.data, true);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "chosen_post_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Cq() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Cr() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
