package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bXa;
    private ak cXe;
    private ak cXf;
    private ak cXg;
    private ak cXh;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bd bdVar) {
        this.bXa = bdVar;
    }

    public static boolean J(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VK() {
        return this.bXa;
    }

    public int alc() {
        return (this.bXa == null || StringUtils.isNull(this.bXa.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cXe = akVar;
    }

    public void c(ak akVar) {
        this.cXf = akVar;
    }

    public void d(ak akVar) {
        this.cXg = akVar;
    }

    public void e(ak akVar) {
        this.cXh = akVar;
    }

    public ak ald() {
        return this.cXe != null ? this.cXe.ab("obj_param3", com.baidu.tieba.card.k.aks()) : this.cXe;
    }

    public ak ale() {
        return this.cXf != null ? this.cXf.ab("obj_param3", com.baidu.tieba.card.k.aks()) : this.cXf;
    }

    public ak alf() {
        return this.cXh != null ? this.cXh.ab("obj_param3", com.baidu.tieba.card.k.aks()) : this.cXh;
    }

    public ak alg() {
        return this.cXg != null ? this.cXg.ab("obj_param3", com.baidu.tieba.card.k.aks()) : this.cXg;
    }
}
