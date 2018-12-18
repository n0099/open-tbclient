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
    protected n dJq;
    protected f dPd;
    protected TextView dPe;
    protected ViewGroup dPf;
    protected FrsStarRankAndTaskContainer dPg;
    private int dPh = 3;

    public void aDk() {
        this.dPe = (TextView) this.egf.findViewById(e.g.top_item_type);
        this.dPe.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.egj = new AdapterLinearLayout(this.dJE.getPageContext().getPageActivity());
        this.egj.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.egj.setOrientation(1);
        this.egj.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds16));
        this.dPd = new f(this.dJE);
        this.dPd.b(this.egV);
        this.egj.setAdapter(this.dPd);
    }

    public void a(n nVar) {
        this.dJq = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bE(List<g> list) {
        if (this.dJE != null && this.dJE.aAZ() != null && this.dPd != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bCz = this.dJE.aAZ().bCz();
            if (!v.I(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bBf() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bCz != null) {
                for (int i2 = 0; i2 < v.H(bCz) && arrayList.size() < this.dPh; i2++) {
                    h hVar = (h) v.d(bCz, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).zA() == 1) {
                            this.dPh = 4;
                        } else if (this.dJE.aAZ().bgh() != null && this.dJE.aAZ().bgh().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dPd instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dPd;
                if (fVar.aDT() != null && this.dJE.aAZ() != null) {
                    if (this.dJE.aAZ().hiz == 1) {
                        fVar.aDT().ebm = true;
                    } else {
                        fVar.aDT().ebm = false;
                    }
                    if (this.dJE.aAZ().bgh() != null) {
                        fVar.aDT().ebo = this.dJE.aAZ().bgh().getId();
                    }
                }
            }
            if (!v.I(list) && list.get(0).bBf() != 1) {
                arrayList.add(list.get(0));
            }
            this.dPd.c(this.dJq);
            this.dPd.setData(arrayList);
            this.dPd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDl() {
        if (this.dPd != null) {
            this.dPd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aDm() {
        if (this.dPd != null) {
            this.dPd.notifyDataSetChanged();
        }
    }
}
