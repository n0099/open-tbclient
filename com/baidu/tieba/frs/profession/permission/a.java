package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.t;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes.dex */
public class a implements h {
    public String forum_id;
    public int hHA;
    public int hHy;
    public int hHz;
    public long thread_id;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> beO() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> beP() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object ii(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        t.a(builder, true, false, true);
        builder.forum_id = Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.forum_id, 0L));
        builder.thread_id = Long.valueOf(this.thread_id);
        builder.req_type = Integer.valueOf(this.hHz == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
