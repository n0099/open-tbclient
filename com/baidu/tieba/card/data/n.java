package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.an;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId Ru = BdUniqueId.gen();
    public bi bbU;
    private ax bcn;
    private ax bco;
    private ax bcp;
    private ax bcq;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ru;
    }

    public n(bi biVar) {
        this.bbU = biVar;
    }

    public static boolean d(bi biVar) {
        return biVar != null && biVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Jv() {
        return this.bbU;
    }

    public int OG() {
        return (this.bbU == null || StringUtils.isNull(this.bbU.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ax axVar) {
        this.bcn = axVar;
    }

    public void c(ax axVar) {
        this.bco = axVar;
    }

    public void d(ax axVar) {
        this.bcp = axVar;
    }

    public void e(ax axVar) {
        this.bcq = axVar;
    }

    public ax OH() {
        return this.bcn != null ? this.bcn.ab("obj_param3", an.Oc()) : this.bcn;
    }

    public ax OI() {
        return this.bco != null ? this.bco.ab("obj_param3", an.Oc()) : this.bco;
    }

    public ax OJ() {
        return this.bcq != null ? this.bcq.ab("obj_param3", an.Oc()) : this.bcq;
    }

    public ax OK() {
        return this.bcp != null ? this.bcp.ab("obj_param3", an.Oc()) : this.bcp;
    }
}
