package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.n;
import java.util.HashMap;
import tbclient.GodFeed.DataReq;
import tbclient.GodFeed.GodFeedReqIdl;
/* loaded from: classes.dex */
public class e implements h {
    private long cJU;
    private int pn;
    private int rn;
    private long tagCode;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> mb() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timeline = Long.valueOf(this.cJU);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m9getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m9getInst()));
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m9getInst()));
        builder.q_type = Integer.valueOf(ay.vC().vE() ? 2 : 1);
        GodFeedReqIdl.Builder builder2 = new GodFeedReqIdl.Builder();
        builder2.data = builder.build(false);
        n.a(builder2.data, true);
        return builder2.build(false);
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void bF(long j) {
        this.cJU = j;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }
}
