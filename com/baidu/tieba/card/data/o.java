package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bj bbv;
    private as bvq;
    private as bvr;
    private as bvs;
    private as bvt;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public o(bj bjVar) {
        this.bbv = bjVar;
    }

    public static boolean n(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj JN() {
        return this.bbv;
    }

    public int ST() {
        return (this.bbv == null || StringUtils.isNull(this.bbv.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(as asVar) {
        this.bvq = asVar;
    }

    public void c(as asVar) {
        this.bvr = asVar;
    }

    public void d(as asVar) {
        this.bvs = asVar;
    }

    public void e(as asVar) {
        this.bvt = asVar;
    }

    public as SU() {
        return this.bvq != null ? this.bvq.Z("obj_param3", at.Sp()) : this.bvq;
    }

    public as SV() {
        return this.bvr != null ? this.bvr.Z("obj_param3", at.Sp()) : this.bvr;
    }

    public as SW() {
        return this.bvt != null ? this.bvt.Z("obj_param3", at.Sp()) : this.bvt;
    }

    public as SX() {
        return this.bvs != null ? this.bvs.Z("obj_param3", at.Sp()) : this.bvs;
    }
}
