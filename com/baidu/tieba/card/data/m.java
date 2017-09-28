package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bNH;
    private ak bNI;
    private ak bNJ;
    private ak bNK;
    public bh bes;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bh bhVar) {
        this.bes = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nj() {
        return this.bes;
    }

    public int Yj() {
        return (this.bes == null || StringUtils.isNull(this.bes.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bNH = akVar;
    }

    public void c(ak akVar) {
        this.bNI = akVar;
    }

    public void d(ak akVar) {
        this.bNJ = akVar;
    }

    public void e(ak akVar) {
        this.bNK = akVar;
    }

    public ak Yk() {
        return this.bNH != null ? this.bNH.ad("obj_param3", com.baidu.tieba.card.m.XG()) : this.bNH;
    }

    public ak Yl() {
        return this.bNI != null ? this.bNI.ad("obj_param3", com.baidu.tieba.card.m.XG()) : this.bNI;
    }

    public ak Ym() {
        return this.bNK != null ? this.bNK.ad("obj_param3", com.baidu.tieba.card.m.XG()) : this.bNK;
    }

    public ak Yn() {
        return this.bNJ != null ? this.bNJ.ad("obj_param3", com.baidu.tieba.card.m.XG()) : this.bNJ;
    }
}
