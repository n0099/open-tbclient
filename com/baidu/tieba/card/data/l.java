package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class l extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bZf;
    private ak daa;
    private ak dab;
    private ak dac;
    private ak dad;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public l(bd bdVar) {
        this.bZf = bdVar;
    }

    public static boolean M(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WD() {
        return this.bZf;
    }

    public int alP() {
        return (this.bZf == null || StringUtils.isNull(this.bZf.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.daa = akVar;
    }

    public void c(ak akVar) {
        this.dab = akVar;
    }

    public void d(ak akVar) {
        this.dac = akVar;
    }

    public void e(ak akVar) {
        this.dad = akVar;
    }

    public ak alQ() {
        return this.daa != null ? this.daa.ab("obj_param3", com.baidu.tieba.card.j.alf()) : this.daa;
    }

    public ak alR() {
        return this.dab != null ? this.dab.ab("obj_param3", com.baidu.tieba.card.j.alf()) : this.dab;
    }

    public ak alS() {
        return this.dad != null ? this.dad.ab("obj_param3", com.baidu.tieba.card.j.alf()) : this.dad;
    }

    public ak alT() {
        return this.dac != null ? this.dac.ab("obj_param3", com.baidu.tieba.card.j.alf()) : this.dac;
    }
}
