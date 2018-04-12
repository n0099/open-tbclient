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
    protected n cYr;
    protected f dcH;
    protected TextView dcI;
    protected ViewGroup dcJ;
    protected FrsStarRankAndTaskContainer dcK;

    public void aro() {
        this.dcI = (TextView) this.dsM.findViewById(d.g.top_item_type);
        this.dcI.setText(TbadkCoreApplication.getInst().getString(d.k.game));
        this.dsQ = new AdapterLinearLayout(this.cYF.getPageContext().getPageActivity());
        this.dsQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dsQ.setOrientation(1);
        this.dsQ.setPadding(0, 0, 0, l.e(this.adf.getPageActivity(), d.e.tbds16));
        this.dcH = new f(this.cYF);
        this.dcH.a(this.dtA);
        this.dsQ.setAdapter(this.dcH);
    }

    public void a(n nVar) {
        this.cYr = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bf(List<g> list) {
        if (this.cYF != null && this.cYF.apE() != null && this.dcH != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bri = this.cYF.apE().bri();
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
            if (this.dcH instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dcH;
                if (com.baidu.tieba.frs.e.c.doy != null && this.cYF.apE() != null) {
                    if (this.cYF.apE().gtS == 1) {
                        com.baidu.tieba.frs.e.c.doy.dom = true;
                    } else {
                        com.baidu.tieba.frs.e.c.doy.dom = false;
                    }
                    if (this.cYF.apE().aVq() != null) {
                        com.baidu.tieba.frs.e.c.doy.doo = this.cYF.apE().aVq().getId();
                    }
                }
            }
            if (!v.w(list) && list.get(0).bpS() != 1) {
                arrayList.add(list.get(0));
            }
            this.dcH.c(this.cYr);
            this.dcH.setData(arrayList);
            this.dcH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arp() {
        if (this.dcH != null) {
            this.dcH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arq() {
        if (this.dcH != null) {
            this.dcH.notifyDataSetChanged();
        }
    }
}
