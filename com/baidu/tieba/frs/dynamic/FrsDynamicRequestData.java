package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.StarTrends.DataReq;
import tbclient.StarTrends.StarTrendsReqIdl;
/* loaded from: classes22.dex */
public class FrsDynamicRequestData extends OrmObject implements e, h {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f3683common;
    public long forumId;
    public long lastThreadId;
    public int qType;
    public double scrDip;
    public int scrH;
    public int scrW;

    @Override // com.baidu.tbadk.mvc.b.e
    public String bBv() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean bBw() {
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
    public HashMap<String, Object> bBy() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> bBz() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object kr(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.scr_w = Integer.valueOf(this.scrW);
        builder.scr_h = Integer.valueOf(this.scrH);
        builder.scr_dip = Double.valueOf(this.scrDip);
        builder.q_type = Integer.valueOf(this.qType);
        builder.last_thread_id = Long.valueOf(this.lastThreadId);
        builder.rn = 30;
        u.a(builder, true, false, true);
        StarTrendsReqIdl.Builder builder2 = new StarTrendsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
