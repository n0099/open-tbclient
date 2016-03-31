package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bc;
/* loaded from: classes.dex */
public class u extends c {
    public static final BdUniqueId TC = BdUniqueId.gen();
    public as aWf;
    private aw aWg;
    private aw aWh;
    private aw aWi;
    private aw aWj;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }

    public u(as asVar) {
        this.aWf = asVar;
    }

    public static boolean b(as asVar) {
        return asVar != null && asVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public as LC() {
        return this.aWf;
    }

    public int LT() {
        return (this.aWf == null || StringUtils.isNull(this.aWf.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aw awVar) {
        this.aWg = awVar;
    }

    public void c(aw awVar) {
        this.aWh = awVar;
    }

    public void d(aw awVar) {
        this.aWi = awVar;
    }

    public void e(aw awVar) {
        this.aWj = awVar;
    }

    public aw LU() {
        return this.aWg != null ? this.aWg.ac("obj_param3", bc.Lr()) : this.aWg;
    }

    public aw LV() {
        return this.aWh != null ? this.aWh.ac("obj_param3", bc.Lr()) : this.aWh;
    }

    public aw LW() {
        return this.aWj != null ? this.aWj.ac("obj_param3", bc.Lr()) : this.aWj;
    }

    public aw LX() {
        return this.aWi != null ? this.aWi.ac("obj_param3", bc.Lr()) : this.aWi;
    }
}
