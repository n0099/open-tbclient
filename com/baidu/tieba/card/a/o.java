package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId aPP = BdUniqueId.gen();
    public z aQp;
    private av aQq;
    private av aQr;
    private av aQs;
    private av aQt;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aPP;
    }

    public o(z zVar) {
        this.aQp = zVar;
    }

    public static boolean b(z zVar) {
        return zVar != null && zVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public z Iv() {
        return this.aQp;
    }

    public int IG() {
        return (this.aQp == null || StringUtils.isNull(this.aQp.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(av avVar) {
        this.aQq = avVar;
    }

    public void c(av avVar) {
        this.aQr = avVar;
    }

    public void d(av avVar) {
        this.aQs = avVar;
    }

    public void e(av avVar) {
        this.aQt = avVar;
    }

    public av IH() {
        return this.aQq != null ? this.aQq.aa("obj_param3", x.Im()) : this.aQq;
    }

    public av II() {
        return this.aQr != null ? this.aQr.aa("obj_param3", x.Im()) : this.aQr;
    }

    public av IJ() {
        return this.aQt != null ? this.aQt.aa("obj_param3", x.Im()) : this.aQt;
    }

    public av IK() {
        return this.aQs != null ? this.aQs.aa("obj_param3", x.Im()) : this.aQs;
    }
}
