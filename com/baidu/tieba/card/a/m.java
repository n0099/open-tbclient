package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.au;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId Oq = BdUniqueId.gen();
    public ax aRZ;
    private aw aSa;
    private aw aSb;
    private aw aSc;
    private aw aSd;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Oq;
    }

    public m(ax axVar) {
        this.aRZ = axVar;
    }

    public static boolean b(ax axVar) {
        return axVar != null && axVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public ax Kn() {
        return this.aRZ;
    }

    public int KE() {
        return (this.aRZ == null || StringUtils.isNull(this.aRZ.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aw awVar) {
        this.aSa = awVar;
    }

    public void c(aw awVar) {
        this.aSb = awVar;
    }

    public void d(aw awVar) {
        this.aSc = awVar;
    }

    public void e(aw awVar) {
        this.aSd = awVar;
    }

    public aw KF() {
        return this.aSa != null ? this.aSa.ac("obj_param3", au.Kc()) : this.aSa;
    }

    public aw KG() {
        return this.aSb != null ? this.aSb.ac("obj_param3", au.Kc()) : this.aSb;
    }

    public aw KH() {
        return this.aSd != null ? this.aSd.ac("obj_param3", au.Kc()) : this.aSd;
    }

    public aw KI() {
        return this.aSc != null ? this.aSc.ac("obj_param3", au.Kc()) : this.aSc;
    }
}
