package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bXi;
    private ak cXA;
    private ak cXB;
    private ak cXC;
    private ak cXz;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bd bdVar) {
        this.bXi = bdVar;
    }

    public static boolean J(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VM() {
        return this.bXi;
    }

    public int alh() {
        return (this.bXi == null || StringUtils.isNull(this.bXi.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cXz = akVar;
    }

    public void c(ak akVar) {
        this.cXA = akVar;
    }

    public void d(ak akVar) {
        this.cXB = akVar;
    }

    public void e(ak akVar) {
        this.cXC = akVar;
    }

    public ak ali() {
        return this.cXz != null ? this.cXz.aa("obj_param3", com.baidu.tieba.card.k.akx()) : this.cXz;
    }

    public ak alj() {
        return this.cXA != null ? this.cXA.aa("obj_param3", com.baidu.tieba.card.k.akx()) : this.cXA;
    }

    public ak alk() {
        return this.cXC != null ? this.cXC.aa("obj_param3", com.baidu.tieba.card.k.akx()) : this.cXC;
    }

    public ak all() {
        return this.cXB != null ? this.cXB.aa("obj_param3", com.baidu.tieba.card.k.akx()) : this.cXB;
    }
}
