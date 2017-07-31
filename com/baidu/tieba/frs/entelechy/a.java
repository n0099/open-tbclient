package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected h cjZ;
    protected f cmC;
    protected TextView cmD;
    protected ViewGroup cmE;
    protected ExpandLayout cmF;
    protected com.baidu.tieba.frs.view.a cmG;

    public void ago() {
        this.cmF = (ExpandLayout) this.czb.findViewById(d.h.expandable_layout);
        this.cmD = (TextView) this.czb.findViewById(d.h.top_item_type);
        this.cmD.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cmC = new f(this.ckn);
        this.cmG = new com.baidu.tieba.frs.view.a(this.ckn, this.cmF, this.czP, this.cmC);
    }

    public void a(h hVar) {
        this.cjZ = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agp() {
        if (this.ckn != null && this.ckn.afr() != null && this.cmC != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> brD = this.ckn.afr().brD();
            if (brD != null) {
                for (int i = 0; i < u.u(brD); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(brD, i);
                    if (fVar instanceof bl) {
                        arrayList.add((bl) fVar);
                    }
                }
            }
            if (this.cmC instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cmC;
                if (com.baidu.tieba.frs.e.c.cvL != null && this.ckn.afr() != null) {
                    if (this.ckn.afr().gfq == 1) {
                        com.baidu.tieba.frs.e.c.cvL.cvB = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cvL.cvB = false;
                    }
                    if (this.ckn.afr().aPh() != null) {
                        com.baidu.tieba.frs.e.c.cvL.cvD = this.ckn.afr().aPh().getId();
                    }
                }
            }
            this.cmG.b(this.cjZ);
            this.cmG.aP(arrayList);
            this.cmG.ajJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agq() {
        if (this.cmC != null) {
            this.cmC.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agr() {
        if (this.cmC != null) {
            this.cmC.notifyDataSetChanged();
        }
    }
}
