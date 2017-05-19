package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bk bcB;
    private as bxA;
    private as bxB;
    private as bxy;
    private as bxz;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bk bkVar) {
        this.bcB = bkVar;
    }

    public static boolean s(bk bkVar) {
        return bkVar != null && bkVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk JB() {
        return this.bcB;
    }

    public int TM() {
        return (this.bcB == null || StringUtils.isNull(this.bcB.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(as asVar) {
        this.bxy = asVar;
    }

    public void c(as asVar) {
        this.bxz = asVar;
    }

    public void d(as asVar) {
        this.bxA = asVar;
    }

    public void e(as asVar) {
        this.bxB = asVar;
    }

    public as TN() {
        return this.bxy != null ? this.bxy.aa("obj_param3", ap.Th()) : this.bxy;
    }

    public as TO() {
        return this.bxz != null ? this.bxz.aa("obj_param3", ap.Th()) : this.bxz;
    }

    public as TP() {
        return this.bxB != null ? this.bxB.aa("obj_param3", ap.Th()) : this.bxB;
    }

    public as TQ() {
        return this.bxA != null ? this.bxA.aa("obj_param3", ap.Th()) : this.bxA;
    }
}
