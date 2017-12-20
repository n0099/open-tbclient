package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bjE;
    private ak cdU;
    private ak cdV;
    private ak cdW;
    private ak cdX;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bd bdVar) {
        this.bjE = bdVar;
    }

    public static boolean F(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjE;
    }

    public int act() {
        return (this.bjE == null || StringUtils.isNull(this.bjE.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cdU = akVar;
    }

    public void c(ak akVar) {
        this.cdV = akVar;
    }

    public void d(ak akVar) {
        this.cdW = akVar;
    }

    public void e(ak akVar) {
        this.cdX = akVar;
    }

    public ak acu() {
        return this.cdU != null ? this.cdU.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdU;
    }

    public ak acv() {
        return this.cdV != null ? this.cdV.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdV;
    }

    public ak acw() {
        return this.cdX != null ? this.cdX.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdX;
    }

    public ak acx() {
        return this.cdW != null ? this.cdW.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdW;
    }
}
