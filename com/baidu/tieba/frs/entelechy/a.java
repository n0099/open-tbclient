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
    protected n dMN;
    protected f dSA;
    protected TextView dSB;
    protected ViewGroup dSC;
    protected FrsStarRankAndTaskContainer dSD;
    private int dSE = 3;

    public void aEw() {
        this.dSB = (TextView) this.ejC.findViewById(e.g.top_item_type);
        this.dSB.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.ejG = new AdapterLinearLayout(this.dNb.getPageContext().getPageActivity());
        this.ejG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ejG.setOrientation(1);
        this.ejG.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds16));
        this.dSA = new f(this.dNb);
        this.dSA.b(this.eks);
        this.ejG.setAdapter(this.dSA);
    }

    public void a(n nVar) {
        this.dMN = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bG(List<g> list) {
        if (this.dNb != null && this.dNb.aCl() != null && this.dSA != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bEa = this.dNb.aCl().bEa();
            if (!v.I(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bCG() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bEa != null) {
                for (int i2 = 0; i2 < v.H(bEa) && arrayList.size() < this.dSE; i2++) {
                    h hVar = (h) v.d(bEa, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).zN() == 1) {
                            this.dSE = 4;
                        } else if (this.dNb.aCl().bhx() != null && this.dNb.aCl().bhx().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dSA instanceof com.baidu.tieba.frs.e.d) {
                f fVar = this.dSA;
                if (fVar.aFf() != null && this.dNb.aCl() != null) {
                    if (this.dNb.aCl().hmP == 1) {
                        fVar.aFf().eeJ = true;
                    } else {
                        fVar.aFf().eeJ = false;
                    }
                    if (this.dNb.aCl().bhx() != null) {
                        fVar.aFf().eeL = this.dNb.aCl().bhx().getId();
                    }
                }
            }
            if (!v.I(list) && list.get(0).bCG() != 1) {
                arrayList.add(list.get(0));
            }
            this.dSA.c(this.dMN);
            this.dSA.setData(arrayList);
            this.dSA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEx() {
        if (this.dSA != null) {
            this.dSA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEy() {
        if (this.dSA != null) {
            this.dSA.notifyDataSetChanged();
        }
    }
}
