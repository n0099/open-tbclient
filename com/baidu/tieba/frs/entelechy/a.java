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
    protected o dFs;
    protected h dJp;
    protected TextView dJq;
    protected ViewGroup dJr;
    protected FrsStarRankAndTaskContainer dJs;

    public void awR() {
        this.dJq = (TextView) this.dXC.findViewById(d.g.top_item_type);
        this.dJq.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dXG = new com.baidu.tieba.frs.view.a(this.dFD.getContext());
        this.dXG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dXG.setOrientation(1);
        this.dXG.setPadding(0, 0, 0, l.t(this.aRG.getPageActivity(), d.e.tbds16));
        this.dJp = new h(this.dFD);
        this.dJp.a(this.dYr);
        this.dXG.setAdapter(this.dJp);
    }

    public void a(o oVar) {
        this.dFs = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(List<g> list) {
        if (this.dFD != null && this.dFD.avk() != null && this.dJp != null) {
            ArrayList arrayList = new ArrayList();
            List<i> bwd = this.dFD.avk().bwd();
            if (!v.E(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).buJ() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bwd != null) {
                for (int i2 = 0; i2 < v.D(bwd) && arrayList.size() < 2; i2++) {
                    i iVar = (i) v.f(bwd, i2);
                    if (iVar instanceof bd) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dJp instanceof com.baidu.tieba.frs.e.c) {
                h hVar = this.dJp;
                if (com.baidu.tieba.frs.e.c.dUe != null && this.dFD.avk() != null) {
                    if (this.dFD.avk().gYa == 1) {
                        com.baidu.tieba.frs.e.c.dUe.dTS = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dUe.dTS = false;
                    }
                    if (this.dFD.avk().bar() != null) {
                        com.baidu.tieba.frs.e.c.dUe.dTU = this.dFD.avk().bar().getId();
                    }
                }
            }
            if (!v.E(list) && list.get(0).buJ() != 1) {
                arrayList.add(list.get(0));
            }
            this.dJp.c(this.dFs);
            this.dJp.setData(arrayList);
            this.dJp.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awS() {
        if (this.dJp != null) {
            this.dJp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awT() {
        if (this.dJp != null) {
            this.dJp.notifyDataSetChanged();
        }
    }
}
