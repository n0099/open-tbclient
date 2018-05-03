package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n cYo;
    protected f dcE;
    protected TextView dcF;
    protected ViewGroup dcG;
    protected FrsStarRankAndTaskContainer dcH;

    public void aro() {
        this.dcF = (TextView) this.dsJ.findViewById(d.g.top_item_type);
        this.dcF.setText(TbadkCoreApplication.getInst().getString(d.k.game));
        this.dsN = new AdapterLinearLayout(this.cYC.getPageContext().getPageActivity());
        this.dsN.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dsN.setOrientation(1);
        this.dsN.setPadding(0, 0, 0, l.e(this.adf.getPageActivity(), d.e.tbds16));
        this.dcE = new f(this.cYC);
        this.dcE.a(this.dtx);
        this.dsN.setAdapter(this.dcE);
    }

    public void a(n nVar) {
        this.cYo = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bf(List<g> list) {
        if (this.cYC != null && this.cYC.apE() != null && this.dcE != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bri = this.cYC.apE().bri();
            if (!v.w(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bpS() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bri != null) {
                for (int i2 = 0; i2 < v.v(bri) && arrayList.size() < 2; i2++) {
                    h hVar = (h) v.c(bri, i2);
                    if (hVar instanceof bd) {
                        arrayList.add(hVar);
                    }
                }
            }
            if (this.dcE instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dcE;
                if (com.baidu.tieba.frs.e.c.dov != null && this.cYC.apE() != null) {
                    if (this.cYC.apE().gtP == 1) {
                        com.baidu.tieba.frs.e.c.dov.doj = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dov.doj = false;
                    }
                    if (this.cYC.apE().aVq() != null) {
                        com.baidu.tieba.frs.e.c.dov.dol = this.cYC.apE().aVq().getId();
                    }
                }
            }
            if (!v.w(list) && list.get(0).bpS() != 1) {
                arrayList.add(list.get(0));
            }
            this.dcE.c(this.cYo);
            this.dcE.setData(arrayList);
            this.dcE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arp() {
        if (this.dcE != null) {
            this.dcE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arq() {
        if (this.dcE != null) {
            this.dcE.notifyDataSetChanged();
        }
    }
}
