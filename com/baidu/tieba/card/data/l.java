package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class l extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bZr;
    private ak dam;
    private ak dan;
    private ak dao;
    private ak dap;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public l(bd bdVar) {
        this.bZr = bdVar;
    }

    public static boolean M(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WE() {
        return this.bZr;
    }

    public int alQ() {
        return (this.bZr == null || StringUtils.isNull(this.bZr.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.dam = akVar;
    }

    public void c(ak akVar) {
        this.dan = akVar;
    }

    public void d(ak akVar) {
        this.dao = akVar;
    }

    public void e(ak akVar) {
        this.dap = akVar;
    }

    public ak alR() {
        return this.dam != null ? this.dam.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dam;
    }

    public ak alS() {
        return this.dan != null ? this.dan.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dan;
    }

    public ak alT() {
        return this.dap != null ? this.dap.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dap;
    }

    public ak alU() {
        return this.dao != null ? this.dao.ab("obj_param3", com.baidu.tieba.card.j.alg()) : this.dao;
    }
}
