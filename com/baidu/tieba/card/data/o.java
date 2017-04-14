package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bi bbo;
    private as bvj;
    private as bvk;
    private as bvl;
    private as bvm;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public o(bi biVar) {
        this.bbo = biVar;
    }

    public static boolean n(bi biVar) {
        return biVar != null && biVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.bbo;
    }

    public int Tr() {
        return (this.bbo == null || StringUtils.isNull(this.bbo.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(as asVar) {
        this.bvj = asVar;
    }

    public void c(as asVar) {
        this.bvk = asVar;
    }

    public void d(as asVar) {
        this.bvl = asVar;
    }

    public void e(as asVar) {
        this.bvm = asVar;
    }

    public as Ts() {
        return this.bvj != null ? this.bvj.aa("obj_param3", at.SN()) : this.bvj;
    }

    public as Tt() {
        return this.bvk != null ? this.bvk.aa("obj_param3", at.SN()) : this.bvk;
    }

    public as Tu() {
        return this.bvm != null ? this.bvm.aa("obj_param3", at.SN()) : this.bvm;
    }

    public as Tv() {
        return this.bvl != null ? this.bvl.aa("obj_param3", at.SN()) : this.bvl;
    }
}
