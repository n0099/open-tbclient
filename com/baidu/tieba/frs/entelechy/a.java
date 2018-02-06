package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.h;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.c {
    protected o dFE;
    protected h dJB;
    protected TextView dJC;
    protected ViewGroup dJD;
    protected FrsStarRankAndTaskContainer dJE;

    public void awS() {
        this.dJC = (TextView) this.dXO.findViewById(d.g.top_item_type);
        this.dJC.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dXS = new com.baidu.tieba.frs.view.a(this.dFP.getContext());
        this.dXS.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dXS.setOrientation(1);
        this.dXS.setPadding(0, 0, 0, l.t(this.aRR.getPageActivity(), d.e.tbds16));
        this.dJB = new h(this.dFP);
        this.dJB.a(this.dYD);
        this.dXS.setAdapter(this.dJB);
    }

    public void a(o oVar) {
        this.dFE = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(List<g> list) {
        if (this.dFP != null && this.dFP.avl() != null && this.dJB != null) {
            ArrayList arrayList = new ArrayList();
            List<i> bwe = this.dFP.avl().bwe();
            if (!v.E(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).buK() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bwe != null) {
                for (int i2 = 0; i2 < v.D(bwe) && arrayList.size() < 2; i2++) {
                    i iVar = (i) v.f(bwe, i2);
                    if (iVar instanceof bd) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dJB instanceof com.baidu.tieba.frs.e.c) {
                h hVar = this.dJB;
                if (com.baidu.tieba.frs.e.c.dUq != null && this.dFP.avl() != null) {
                    if (this.dFP.avl().gYp == 1) {
                        com.baidu.tieba.frs.e.c.dUq.dUe = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dUq.dUe = false;
                    }
                    if (this.dFP.avl().bas() != null) {
                        com.baidu.tieba.frs.e.c.dUq.dUg = this.dFP.avl().bas().getId();
                    }
                }
            }
            if (!v.E(list) && list.get(0).buK() != 1) {
                arrayList.add(list.get(0));
            }
            this.dJB.c(this.dFE);
            this.dJB.setData(arrayList);
            this.dJB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awT() {
        if (this.dJB != null) {
            this.dJB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awU() {
        if (this.dJB != null) {
            this.dJB.notifyDataSetChanged();
        }
    }
}
