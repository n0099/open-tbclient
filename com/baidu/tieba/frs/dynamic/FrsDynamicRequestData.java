package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.q;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.StarTrends.DataReq;
import tbclient.StarTrends.StarTrendsReqIdl;
/* loaded from: classes6.dex */
public class FrsDynamicRequestData extends OrmObject implements e, h {
    public CommonReq common;
    public long forumId;
    public long lastThreadId;
    public int qType;
    public double scrDip;
    public int scrH;
    public int scrW;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Oq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Or() {
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
    public HashMap<String, Object> Ot() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> Ou() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cG(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.scr_w = Integer.valueOf(this.scrW);
        builder.scr_h = Integer.valueOf(this.scrH);
        builder.scr_dip = Double.valueOf(this.scrDip);
        builder.q_type = Integer.valueOf(this.qType);
        builder.last_thread_id = Long.valueOf(this.lastThreadId);
        builder.rn = 30;
        q.bindCommonParamsToProtobufData(builder, true, false, true);
        StarTrendsReqIdl.Builder builder2 = new StarTrendsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
