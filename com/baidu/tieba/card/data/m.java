package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bNv;
    private ak bNw;
    private ak bNx;
    private ak bNy;
    public bh bee;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bh bhVar) {
        this.bee = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nd() {
        return this.bee;
    }

    public int Yf() {
        return (this.bee == null || StringUtils.isNull(this.bee.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bNv = akVar;
    }

    public void c(ak akVar) {
        this.bNw = akVar;
    }

    public void d(ak akVar) {
        this.bNx = akVar;
    }

    public void e(ak akVar) {
        this.bNy = akVar;
    }

    public ak Yg() {
        return this.bNv != null ? this.bNv.ac("obj_param3", com.baidu.tieba.card.m.XC()) : this.bNv;
    }

    public ak Yh() {
        return this.bNw != null ? this.bNw.ac("obj_param3", com.baidu.tieba.card.m.XC()) : this.bNw;
    }

    public ak Yi() {
        return this.bNy != null ? this.bNy.ac("obj_param3", com.baidu.tieba.card.m.XC()) : this.bNy;
    }

    public ak Yj() {
        return this.bNx != null ? this.bNx.ac("obj_param3", com.baidu.tieba.card.m.XC()) : this.bNx;
    }
}
