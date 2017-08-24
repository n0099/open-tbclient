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
    protected h ckN;
    protected f cno;
    protected TextView cnp;
    protected ViewGroup cnq;
    protected ExpandLayout cnr;
    protected com.baidu.tieba.frs.view.a cns;

    public void agD() {
        this.cnr = (ExpandLayout) this.cAV.findViewById(d.h.expandable_layout);
        this.cnp = (TextView) this.cAV.findViewById(d.h.top_item_type);
        this.cnp.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cno = new f(this.cla);
        this.cns = new com.baidu.tieba.frs.view.a(this.cla, this.cnr, this.cBJ, this.cno);
    }

    public void a(h hVar) {
        this.ckN = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agE() {
        if (this.cla != null && this.cla.afH() != null && this.cno != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> bse = this.cla.afH().bse();
            if (bse != null) {
                for (int i = 0; i < u.u(bse); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(bse, i);
                    if (fVar instanceof bl) {
                        arrayList.add((bl) fVar);
                    }
                }
            }
            if (this.cno instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cno;
                if (com.baidu.tieba.frs.e.c.cxO != null && this.cla.afH() != null) {
                    if (this.cla.afH().ghi == 1) {
                        com.baidu.tieba.frs.e.c.cxO.cxE = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cxO.cxE = false;
                    }
                    if (this.cla.afH().aPJ() != null) {
                        com.baidu.tieba.frs.e.c.cxO.cxG = this.cla.afH().aPJ().getId();
                    }
                }
            }
            this.cns.b(this.ckN);
            this.cns.aS(arrayList);
            this.cns.aki();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agF() {
        if (this.cno != null) {
            this.cno.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agG() {
        if (this.cno != null) {
            this.cno.notifyDataSetChanged();
        }
    }
}
