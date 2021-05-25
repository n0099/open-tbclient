package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import d.a.m0.g0.b.d;
import d.a.m0.g0.b.g;
import d.a.m0.z0.w;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.StarTrends.DataReq;
import tbclient.StarTrends.StarTrendsReqIdl;
/* loaded from: classes4.dex */
public class FrsDynamicRequestData extends OrmObject implements g, d {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f15282common;
    public long forumId;
    public long lastThreadId;
    public int qType;
    public double scrDip;
    public int scrH;
    public int scrW;

    @Override // d.a.m0.g0.b.i
    public Object c(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.scr_w = Integer.valueOf(this.scrW);
        builder.scr_h = Integer.valueOf(this.scrH);
        builder.scr_dip = Double.valueOf(this.scrDip);
        builder.q_type = Integer.valueOf(this.qType);
        builder.last_thread_id = Long.valueOf(this.lastThreadId);
        builder.rn = 30;
        w.c(builder, true, false, true);
        StarTrendsReqIdl.Builder builder2 = new StarTrendsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.a.m0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    @Override // d.a.m0.g0.b.d
    public boolean i() {
        return false;
    }

    @Override // d.a.m0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, Object> o() {
        return null;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, String> q() {
        return null;
    }

    @Override // d.a.m0.g0.b.d
    public String r() {
        return null;
    }
}
