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
    protected n dBA;
    protected f dHA;
    protected TextView dHB;
    protected ViewGroup dHC;
    protected FrsStarRankAndTaskContainer dHD;
    private int dHE = 3;

    public void aCf() {
        this.dHB = (TextView) this.dYi.findViewById(e.g.top_item_type);
        this.dHB.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.dYm = new AdapterLinearLayout(this.dBO.getPageContext().getPageActivity());
        this.dYm.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dYm.setOrientation(1);
        this.dYm.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0175e.tbds16));
        this.dHA = new f(this.dBO);
        this.dHA.b(this.dYY);
        this.dYm.setAdapter(this.dHA);
    }

    public void a(n nVar) {
        this.dBA = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bE(List<g> list) {
        if (this.dBO != null && this.dBO.azR() != null && this.dHA != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bBj = this.dBO.azR().bBj();
            if (!v.J(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bzQ() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bBj != null) {
                for (int i2 = 0; i2 < v.I(bBj) && arrayList.size() < this.dHE; i2++) {
                    h hVar = (h) v.d(bBj, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).yp() == 1) {
                            this.dHE = 4;
                        } else if (this.dBO.azR().beT() != null && this.dBO.azR().beT().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dHA instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dHA;
                if (fVar.aCM() != null && this.dBO.azR() != null) {
                    if (this.dBO.azR().hai == 1) {
                        fVar.aCM().dTC = true;
                    } else {
                        fVar.aCM().dTC = false;
                    }
                    if (this.dBO.azR().beT() != null) {
                        fVar.aCM().dTE = this.dBO.azR().beT().getId();
                    }
                }
            }
            if (!v.J(list) && list.get(0).bzQ() != 1) {
                arrayList.add(list.get(0));
            }
            this.dHA.c(this.dBA);
            this.dHA.setData(arrayList);
            this.dHA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCg() {
        if (this.dHA != null) {
            this.dHA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aCh() {
        if (this.dHA != null) {
            this.dHA.notifyDataSetChanged();
        }
    }
}
