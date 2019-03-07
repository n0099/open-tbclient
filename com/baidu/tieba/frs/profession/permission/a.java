package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.s;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes.dex */
public class a implements h {
    public String forum_id;
    public int fsg;
    public int fsh;
    public int fsi;
    public long thread_id;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> anZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> aoa() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object eW(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        s.bindCommonParamsToProtobufData(builder, true, false, true);
        builder.forum_id = Long.valueOf(com.baidu.adp.lib.g.b.d(this.forum_id, 0L));
        builder.thread_id = Long.valueOf(this.thread_id);
        builder.req_type = Integer.valueOf(this.fsh == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
