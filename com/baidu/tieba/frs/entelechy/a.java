package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n diM;
    protected f dna;
    protected TextView dnb;
    protected ViewGroup dnc;
    protected FrsStarRankAndTaskContainer dnd;

    public void avs() {
        this.dnb = (TextView) this.dDe.findViewById(d.g.top_item_type);
        this.dnb.setText(TbadkCoreApplication.getInst().getString(d.k.game));
        this.dDi = new AdapterLinearLayout(this.diZ.getPageContext().getPageActivity());
        this.dDi.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dDi.setOrientation(1);
        this.dDi.setPadding(0, 0, 0, l.e(this.mContext.getPageActivity(), d.e.tbds16));
        this.dna = new f(this.diZ);
        this.dna.a(this.dDS);
        this.dDi.setAdapter(this.dna);
    }

    public void a(n nVar) {
        this.diM = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(List<g> list) {
        if (this.diZ != null && this.diZ.atI() != null && this.dna != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bwi = this.diZ.atI().bwi();
            if (!w.z(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).buR() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bwi != null) {
                for (int i2 = 0; i2 < w.y(bwi) && arrayList.size() < 2; i2++) {
                    h hVar = (h) w.c(bwi, i2);
                    if (hVar instanceof bd) {
                        arrayList.add(hVar);
                    }
                }
            }
            if (this.dna instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dna;
                if (com.baidu.tieba.frs.e.c.dyP != null && this.diZ.atI() != null) {
                    if (this.diZ.atI().gGr == 1) {
                        com.baidu.tieba.frs.e.c.dyP.dyD = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dyP.dyD = false;
                    }
                    if (this.diZ.atI().bam() != null) {
                        com.baidu.tieba.frs.e.c.dyP.dyF = this.diZ.atI().bam().getId();
                    }
                }
            }
            if (!w.z(list) && list.get(0).buR() != 1) {
                arrayList.add(list.get(0));
            }
            this.dna.c(this.diM);
            this.dna.setData(arrayList);
            this.dna.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avt() {
        if (this.dna != null) {
            this.dna.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void avu() {
        if (this.dna != null) {
            this.dna.notifyDataSetChanged();
        }
    }
}
