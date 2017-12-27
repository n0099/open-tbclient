package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public be bWT;
    private ak cSC;
    private ak cSD;
    private ak cSE;
    private ak cSF;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(be beVar) {
        this.bWT = beVar;
    }

    public static boolean J(be beVar) {
        return beVar != null && beVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public be VW() {
        return this.bWT;
    }

    public int ajZ() {
        return (this.bWT == null || StringUtils.isNull(this.bWT.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cSC = akVar;
    }

    public void c(ak akVar) {
        this.cSD = akVar;
    }

    public void d(ak akVar) {
        this.cSE = akVar;
    }

    public void e(ak akVar) {
        this.cSF = akVar;
    }

    public ak aka() {
        return this.cSC != null ? this.cSC.ab("obj_param3", com.baidu.tieba.card.k.ajp()) : this.cSC;
    }

    public ak akb() {
        return this.cSD != null ? this.cSD.ab("obj_param3", com.baidu.tieba.card.k.ajp()) : this.cSD;
    }

    public ak akc() {
        return this.cSF != null ? this.cSF.ab("obj_param3", com.baidu.tieba.card.k.ajp()) : this.cSF;
    }

    public ak akd() {
        return this.cSE != null ? this.cSE.ab("obj_param3", com.baidu.tieba.card.k.ajp()) : this.cSE;
    }
}
