package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n dMe;
    protected f dRR;
    protected TextView dRS;
    protected ViewGroup dRT;
    protected FrsStarRankAndTaskContainer dRU;
    private int dRV = 3;

    public void aDZ() {
        this.dRS = (TextView) this.eiW.findViewById(e.g.top_item_type);
        this.dRS.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.eja = new AdapterLinearLayout(this.dMs.getPageContext().getPageActivity());
        this.eja.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.eja.setOrientation(1);
        this.eja.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds16));
        this.dRR = new f(this.dMs);
        this.dRR.b(this.ejM);
        this.eja.setAdapter(this.dRR);
    }

    public void a(n nVar) {
        this.dMe = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bF(List<g> list) {
        if (this.dMs != null && this.dMs.aBO() != null && this.dRR != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bDr = this.dMs.aBO().bDr();
            if (!v.I(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bBX() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bDr != null) {
                for (int i2 = 0; i2 < v.H(bDr) && arrayList.size() < this.dRV; i2++) {
                    h hVar = (h) v.d(bDr, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).zA() == 1) {
                            this.dRV = 4;
                        } else if (this.dMs.aBO().bgT() != null && this.dMs.aBO().bgT().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dRR instanceof com.baidu.tieba.frs.e.d) {
                f fVar = this.dRR;
                if (fVar.aEI() != null && this.dMs.aBO() != null) {
                    if (this.dMs.aBO().hlK == 1) {
                        fVar.aEI().eed = true;
                    } else {
                        fVar.aEI().eed = false;
                    }
                    if (this.dMs.aBO().bgT() != null) {
                        fVar.aEI().eef = this.dMs.aBO().bgT().getId();
                    }
                }
            }
            if (!v.I(list) && list.get(0).bBX() != 1) {
                arrayList.add(list.get(0));
            }
            this.dRR.c(this.dMe);
            this.dRR.setData(arrayList);
            this.dRR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEa() {
        if (this.dRR != null) {
            this.dRR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEb() {
        if (this.dRR != null) {
            this.dRR.notifyDataSetChanged();
        }
    }
}
