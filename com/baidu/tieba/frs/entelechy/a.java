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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.c {
    protected o dFw;
    protected h dJu;
    protected TextView dJv;
    protected ViewGroup dJw;
    protected FrsStarRankAndTaskContainer dJx;

    public void awT() {
        this.dJv = (TextView) this.dXI.findViewById(d.g.top_item_type);
        this.dJv.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dXM = new com.baidu.tieba.frs.view.a(this.dFH.getContext());
        this.dXM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dXM.setOrientation(1);
        this.dXM.setPadding(0, 0, 0, l.t(this.aRI.getPageActivity(), d.e.tbds16));
        this.dJu = new h(this.dFH);
        this.dJu.a(this.dYx);
        this.dXM.setAdapter(this.dJu);
    }

    public void a(o oVar) {
        this.dFw = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(List<com.baidu.tieba.tbadkCore.h> list) {
        if (this.dFH != null && this.dFH.avl() != null && this.dJu != null) {
            ArrayList arrayList = new ArrayList();
            List<i> bwi = this.dFH.avl().bwi();
            if (!v.E(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).buL() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bwi != null) {
                for (int i2 = 0; i2 < v.D(bwi) && arrayList.size() < 2; i2++) {
                    i iVar = (i) v.f(bwi, i2);
                    if (iVar instanceof bd) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dJu instanceof com.baidu.tieba.frs.e.c) {
                h hVar = this.dJu;
                if (com.baidu.tieba.frs.e.c.dUj != null && this.dFH.avl() != null) {
                    if (this.dFH.avl().gYv == 1) {
                        com.baidu.tieba.frs.e.c.dUj.dTX = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dUj.dTX = false;
                    }
                    if (this.dFH.avl().bas() != null) {
                        com.baidu.tieba.frs.e.c.dUj.dTZ = this.dFH.avl().bas().getId();
                    }
                }
            }
            if (!v.E(list) && list.get(0).buL() != 1) {
                arrayList.add(list.get(0));
            }
            this.dJu.c(this.dFw);
            this.dJu.setData(arrayList);
            this.dJu.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awU() {
        if (this.dJu != null) {
            this.dJu.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awV() {
        if (this.dJu != null) {
            this.dJu.notifyDataSetChanged();
        }
    }
}
