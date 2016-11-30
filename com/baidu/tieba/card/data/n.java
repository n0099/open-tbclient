package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.an;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    public bk beS;
    private av bfm;
    private av bfn;
    private av bfo;
    private av bfp;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }

    public n(bk bkVar) {
        this.beS = bkVar;
    }

    public static boolean g(bk bkVar) {
        return bkVar != null && bkVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk Jz() {
        return this.beS;
    }

    public int PJ() {
        return (this.beS == null || StringUtils.isNull(this.beS.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(av avVar) {
        this.bfm = avVar;
    }

    public void c(av avVar) {
        this.bfn = avVar;
    }

    public void d(av avVar) {
        this.bfo = avVar;
    }

    public void e(av avVar) {
        this.bfp = avVar;
    }

    public av PK() {
        return this.bfm != null ? this.bfm.ab("obj_param3", an.Pe()) : this.bfm;
    }

    public av PL() {
        return this.bfn != null ? this.bfn.ab("obj_param3", an.Pe()) : this.bfn;
    }

    public av PM() {
        return this.bfp != null ? this.bfp.ab("obj_param3", an.Pe()) : this.bfp;
    }

    public av PN() {
        return this.bfo != null ? this.bfo.ab("obj_param3", an.Pe()) : this.bfo;
    }
}
