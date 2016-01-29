package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ae;
/* loaded from: classes.dex */
public class r extends c {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    public ah aSu;
    private au aSv;
    private au aSw;
    private au aSx;
    private au aSy;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }

    public r(ah ahVar) {
        this.aSu = ahVar;
    }

    public static boolean b(ah ahVar) {
        return ahVar != null && ahVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public ah Ki() {
        return this.aSu;
    }

    public int Kz() {
        return (this.aSu == null || StringUtils.isNull(this.aSu.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(au auVar) {
        this.aSv = auVar;
    }

    public void c(au auVar) {
        this.aSw = auVar;
    }

    public void d(au auVar) {
        this.aSx = auVar;
    }

    public void e(au auVar) {
        this.aSy = auVar;
    }

    public au KA() {
        return this.aSv != null ? this.aSv.aa("obj_param3", ae.JU()) : this.aSv;
    }

    public au KB() {
        return this.aSw != null ? this.aSw.aa("obj_param3", ae.JU()) : this.aSw;
    }

    public au KC() {
        return this.aSy != null ? this.aSy.aa("obj_param3", ae.JU()) : this.aSy;
    }

    public au KD() {
        return this.aSx != null ? this.aSx.aa("obj_param3", ae.JU()) : this.aSx;
    }
}
