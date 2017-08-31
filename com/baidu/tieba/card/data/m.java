package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bNl;
    private ak bNm;
    private ak bNn;
    private ak bNo;
    public bj bcJ;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bj bjVar) {
        this.bcJ = bjVar;
    }

    public static boolean F(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.bcJ;
    }

    public int Yq() {
        return (this.bcJ == null || StringUtils.isNull(this.bcJ.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bNl = akVar;
    }

    public void c(ak akVar) {
        this.bNm = akVar;
    }

    public void d(ak akVar) {
        this.bNn = akVar;
    }

    public void e(ak akVar) {
        this.bNo = akVar;
    }

    public ak Yr() {
        return this.bNl != null ? this.bNl.ad("obj_param3", com.baidu.tieba.card.m.XP()) : this.bNl;
    }

    public ak Ys() {
        return this.bNm != null ? this.bNm.ad("obj_param3", com.baidu.tieba.card.m.XP()) : this.bNm;
    }

    public ak Yt() {
        return this.bNo != null ? this.bNo.ad("obj_param3", com.baidu.tieba.card.m.XP()) : this.bNo;
    }

    public ak Yu() {
        return this.bNn != null ? this.bNn.ad("obj_param3", com.baidu.tieba.card.m.XP()) : this.bNn;
    }
}
