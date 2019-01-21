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
    protected n dMO;
    protected f dSB;
    protected TextView dSC;
    protected ViewGroup dSD;
    protected FrsStarRankAndTaskContainer dSE;
    private int dSF = 3;

    public void aEw() {
        this.dSC = (TextView) this.ejD.findViewById(e.g.top_item_type);
        this.dSC.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.ejH = new AdapterLinearLayout(this.dNc.getPageContext().getPageActivity());
        this.ejH.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ejH.setOrientation(1);
        this.ejH.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds16));
        this.dSB = new f(this.dNc);
        this.dSB.b(this.ekt);
        this.ejH.setAdapter(this.dSB);
    }

    public void a(n nVar) {
        this.dMO = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bG(List<g> list) {
        if (this.dNc != null && this.dNc.aCl() != null && this.dSB != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bEa = this.dNc.aCl().bEa();
            if (!v.I(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bCG() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bEa != null) {
                for (int i2 = 0; i2 < v.H(bEa) && arrayList.size() < this.dSF; i2++) {
                    h hVar = (h) v.d(bEa, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).zN() == 1) {
                            this.dSF = 4;
                        } else if (this.dNc.aCl().bhx() != null && this.dNc.aCl().bhx().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dSB instanceof com.baidu.tieba.frs.e.d) {
                f fVar = this.dSB;
                if (fVar.aFf() != null && this.dNc.aCl() != null) {
                    if (this.dNc.aCl().hmQ == 1) {
                        fVar.aFf().eeK = true;
                    } else {
                        fVar.aFf().eeK = false;
                    }
                    if (this.dNc.aCl().bhx() != null) {
                        fVar.aFf().eeM = this.dNc.aCl().bhx().getId();
                    }
                }
            }
            if (!v.I(list) && list.get(0).bCG() != 1) {
                arrayList.add(list.get(0));
            }
            this.dSB.c(this.dMO);
            this.dSB.setData(arrayList);
            this.dSB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEx() {
        if (this.dSB != null) {
            this.dSB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEy() {
        if (this.dSB != null) {
            this.dSB.notifyDataSetChanged();
        }
    }
}
