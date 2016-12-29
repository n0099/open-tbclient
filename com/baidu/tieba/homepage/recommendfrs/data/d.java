package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.n;
import java.util.HashMap;
import tbclient.ExcFrsPage.DataReq;
import tbclient.ExcFrsPage.ExcFrsPageReqIdl;
/* loaded from: classes.dex */
public class d implements h {
    private long ctd;
    private int pn;
    private long tagCode;

    public void setPn(int i) {
        this.pn = i;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public long ajE() {
        return this.ctd;
    }

    public void bx(long j) {
        this.ctd = j;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> mb() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(k.I(TbadkCoreApplication.m9getInst()));
        builder.scr_h = Integer.valueOf(k.J(TbadkCoreApplication.m9getInst()));
        builder.scr_dip = Double.valueOf(k.K(TbadkCoreApplication.m9getInst()));
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.q_type = Integer.valueOf(aw.vm().vo() ? 2 : 1);
        builder.last_rank = Long.valueOf(this.ctd);
        ExcFrsPageReqIdl.Builder builder2 = new ExcFrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        n.a(builder2.data, true);
        return builder2.build(false);
    }
}
