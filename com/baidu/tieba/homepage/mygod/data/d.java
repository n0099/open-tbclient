package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.o;
import java.util.HashMap;
import tbclient.GodFeed.DataReq;
import tbclient.GodFeed.GodFeedReqIdl;
/* loaded from: classes.dex */
public class d implements h {
    private long csP;
    private int pn;
    private int rn;
    private long tagCode;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> ld() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object Y(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timeline = Long.valueOf(this.csP);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_w = Integer.valueOf(k.A(TbadkCoreApplication.m10getInst()));
        builder.scr_h = Integer.valueOf(k.B(TbadkCoreApplication.m10getInst()));
        builder.scr_dip = Double.valueOf(k.C(TbadkCoreApplication.m10getInst()));
        builder.q_type = Integer.valueOf(bb.ue().ug() ? 2 : 1);
        GodFeedReqIdl.Builder builder2 = new GodFeedReqIdl.Builder();
        builder2.data = builder.build(false);
        o.a(builder2.data, true);
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

    public void bk(long j) {
        this.csP = j;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }
}
