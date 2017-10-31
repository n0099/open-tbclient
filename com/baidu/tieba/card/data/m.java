package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bUZ;
    private ak bVa;
    private ak bVb;
    private ak bVc;
    public bh beV;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bh bhVar) {
        this.beV = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Np() {
        return this.beV;
    }

    public int aap() {
        return (this.beV == null || StringUtils.isNull(this.beV.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bUZ = akVar;
    }

    public void c(ak akVar) {
        this.bVa = akVar;
    }

    public void d(ak akVar) {
        this.bVb = akVar;
    }

    public void e(ak akVar) {
        this.bVc = akVar;
    }

    public ak aaq() {
        return this.bUZ != null ? this.bUZ.ac("obj_param3", com.baidu.tieba.card.m.ZM()) : this.bUZ;
    }

    public ak aar() {
        return this.bVa != null ? this.bVa.ac("obj_param3", com.baidu.tieba.card.m.ZM()) : this.bVa;
    }

    public ak aas() {
        return this.bVc != null ? this.bVc.ac("obj_param3", com.baidu.tieba.card.m.ZM()) : this.bVc;
    }

    public ak aat() {
        return this.bVb != null ? this.bVb.ac("obj_param3", com.baidu.tieba.card.m.ZM()) : this.bVb;
    }
}
