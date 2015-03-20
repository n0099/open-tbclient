package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.util.j;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes.dex */
public class c implements e, i {
    private int aBu;

    public c(int i) {
        this.aBu = i;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object V(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.aBu);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        j.a(builder2.data, true);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "chosen_post_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String zR() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ax() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
