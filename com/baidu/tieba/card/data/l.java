package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class l extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bZi;
    private ak dad;
    private ak dae;
    private ak daf;
    private ak dag;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public l(bd bdVar) {
        this.bZi = bdVar;
    }

    public static boolean M(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WE() {
        return this.bZi;
    }

    public int alQ() {
        return (this.bZi == null || StringUtils.isNull(this.bZi.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.dad = akVar;
    }

    public void c(ak akVar) {
        this.dae = akVar;
    }

    public void d(ak akVar) {
        this.daf = akVar;
    }

    public void e(ak akVar) {
        this.dag = akVar;
    }

    public ak alR() {
        return this.dad != null ? this.dad.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dad;
    }

    public ak alS() {
        return this.dae != null ? this.dae.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dae;
    }

    public ak alT() {
        return this.dag != null ? this.dag.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dag;
    }

    public ak alU() {
        return this.daf != null ? this.daf.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.daf;
    }
}
