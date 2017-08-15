package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private aj bKs;
    private aj bKt;
    private aj bKu;
    private aj bKv;
    public bl bcM;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bl blVar) {
        this.bcM = blVar;
    }

    public static boolean B(bl blVar) {
        return blVar != null && blVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcM;
    }

    public int Xq() {
        return (this.bcM == null || StringUtils.isNull(this.bcM.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aj ajVar) {
        this.bKs = ajVar;
    }

    public void c(aj ajVar) {
        this.bKt = ajVar;
    }

    public void d(aj ajVar) {
        this.bKu = ajVar;
    }

    public void e(aj ajVar) {
        this.bKv = ajVar;
    }

    public aj Xr() {
        return this.bKs != null ? this.bKs.aa("obj_param3", com.baidu.tieba.card.m.WO()) : this.bKs;
    }

    public aj Xs() {
        return this.bKt != null ? this.bKt.aa("obj_param3", com.baidu.tieba.card.m.WO()) : this.bKt;
    }

    public aj Xt() {
        return this.bKv != null ? this.bKv.aa("obj_param3", com.baidu.tieba.card.m.WO()) : this.bKv;
    }

    public aj Xu() {
        return this.bKu != null ? this.bKu.aa("obj_param3", com.baidu.tieba.card.m.WO()) : this.bKu;
    }
}
