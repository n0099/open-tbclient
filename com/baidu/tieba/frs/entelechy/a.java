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
    protected n dCR;
    protected f dIE;
    protected TextView dIF;
    protected ViewGroup dIG;
    protected FrsStarRankAndTaskContainer dIH;
    private int dII = 3;

    public void aBA() {
        this.dIF = (TextView) this.dZC.findViewById(e.g.top_item_type);
        this.dIF.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.dZG = new AdapterLinearLayout(this.dDf.getPageContext().getPageActivity());
        this.dZG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dZG.setOrientation(1);
        this.dZG.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0200e.tbds16));
        this.dIE = new f(this.dDf);
        this.dIE.b(this.eas);
        this.dZG.setAdapter(this.dIE);
    }

    public void a(n nVar) {
        this.dCR = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(List<g> list) {
        if (this.dDf != null && this.dDf.azp() != null && this.dIE != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bAF = this.dDf.azp().bAF();
            if (!v.I(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bzm() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bAF != null) {
                for (int i2 = 0; i2 < v.H(bAF) && arrayList.size() < this.dII; i2++) {
                    h hVar = (h) v.d(bAF, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).yw() == 1) {
                            this.dII = 4;
                        } else if (this.dDf.azp().ber() != null && this.dDf.azp().ber().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dIE instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dIE;
                if (fVar.aCh() != null && this.dDf.azp() != null) {
                    if (this.dDf.azp().hbG == 1) {
                        fVar.aCh().dUJ = true;
                    } else {
                        fVar.aCh().dUJ = false;
                    }
                    if (this.dDf.azp().ber() != null) {
                        fVar.aCh().dUL = this.dDf.azp().ber().getId();
                    }
                }
            }
            if (!v.I(list) && list.get(0).bzm() != 1) {
                arrayList.add(list.get(0));
            }
            this.dIE.c(this.dCR);
            this.dIE.setData(arrayList);
            this.dIE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBB() {
        if (this.dIE != null) {
            this.dIE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aBC() {
        if (this.dIE != null) {
            this.dIE.notifyDataSetChanged();
        }
    }
}
