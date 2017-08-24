package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private aj bKt;
    private aj bKu;
    private aj bKv;
    private aj bKw;
    public bl bcN;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bl blVar) {
        this.bcN = blVar;
    }

    public static boolean B(bl blVar) {
        return blVar != null && blVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcN;
    }

    public int Xn() {
        return (this.bcN == null || StringUtils.isNull(this.bcN.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aj ajVar) {
        this.bKt = ajVar;
    }

    public void c(aj ajVar) {
        this.bKu = ajVar;
    }

    public void d(aj ajVar) {
        this.bKv = ajVar;
    }

    public void e(aj ajVar) {
        this.bKw = ajVar;
    }

    public aj Xo() {
        return this.bKt != null ? this.bKt.aa("obj_param3", com.baidu.tieba.card.m.WL()) : this.bKt;
    }

    public aj Xp() {
        return this.bKu != null ? this.bKu.aa("obj_param3", com.baidu.tieba.card.m.WL()) : this.bKu;
    }

    public aj Xq() {
        return this.bKw != null ? this.bKw.aa("obj_param3", com.baidu.tieba.card.m.WL()) : this.bKw;
    }

    public aj Xr() {
        return this.bKv != null ? this.bKv.aa("obj_param3", com.baidu.tieba.card.m.WL()) : this.bKv;
    }
}
