package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.r;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.StarTrends.DataReq;
import tbclient.StarTrends.StarTrendsReqIdl;
/* loaded from: classes4.dex */
public class FrsDynamicRequestData extends OrmObject implements e, h {
    public CommonReq common;
    public long forumId;
    public long lastThreadId;
    public int qType;
    public double scrDip;
    public int scrH;
    public int scrW;

    @Override // com.baidu.tbadk.mvc.b.e
    public String avI() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean avJ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> avL() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> avM() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object fq(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.scr_w = Integer.valueOf(this.scrW);
        builder.scr_h = Integer.valueOf(this.scrH);
        builder.scr_dip = Double.valueOf(this.scrDip);
        builder.q_type = Integer.valueOf(this.qType);
        builder.last_thread_id = Long.valueOf(this.lastThreadId);
        builder.rn = 30;
        r.a(builder, true, false, true);
        StarTrendsReqIdl.Builder builder2 = new StarTrendsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
