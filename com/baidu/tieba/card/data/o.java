package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bi bck;
    private as bxA;
    private as bxB;
    private as bxC;
    private as bxD;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public o(bi biVar) {
        this.bck = biVar;
    }

    public static boolean n(bi biVar) {
        return biVar != null && biVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.bck;
    }

    public int Ut() {
        return (this.bck == null || StringUtils.isNull(this.bck.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(as asVar) {
        this.bxA = asVar;
    }

    public void c(as asVar) {
        this.bxB = asVar;
    }

    public void d(as asVar) {
        this.bxC = asVar;
    }

    public void e(as asVar) {
        this.bxD = asVar;
    }

    public as Uu() {
        return this.bxA != null ? this.bxA.aa("obj_param3", at.TP()) : this.bxA;
    }

    public as Uv() {
        return this.bxB != null ? this.bxB.aa("obj_param3", at.TP()) : this.bxB;
    }

    public as Uw() {
        return this.bxD != null ? this.bxD.aa("obj_param3", at.TP()) : this.bxD;
    }

    public as Ux() {
        return this.bxC != null ? this.bxC.aa("obj_param3", at.TP()) : this.bxC;
    }
}
