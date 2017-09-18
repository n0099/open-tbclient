package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bOc;
    private ak bOd;
    private ak bOe;
    private ak bOf;
    public bj bcG;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bj bjVar) {
        this.bcG = bjVar;
    }

    public static boolean F(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.bcG;
    }

    public int YB() {
        return (this.bcG == null || StringUtils.isNull(this.bcG.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bOc = akVar;
    }

    public void c(ak akVar) {
        this.bOd = akVar;
    }

    public void d(ak akVar) {
        this.bOe = akVar;
    }

    public void e(ak akVar) {
        this.bOf = akVar;
    }

    public ak YC() {
        return this.bOc != null ? this.bOc.ad("obj_param3", com.baidu.tieba.card.m.Ya()) : this.bOc;
    }

    public ak YD() {
        return this.bOd != null ? this.bOd.ad("obj_param3", com.baidu.tieba.card.m.Ya()) : this.bOd;
    }

    public ak YE() {
        return this.bOf != null ? this.bOf.ad("obj_param3", com.baidu.tieba.card.m.Ya()) : this.bOf;
    }

    public ak YF() {
        return this.bOe != null ? this.bOe.ad("obj_param3", com.baidu.tieba.card.m.Ya()) : this.bOe;
    }
}
