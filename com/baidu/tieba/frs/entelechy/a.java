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
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n dtz;
    protected f dzA;
    protected TextView dzB;
    protected ViewGroup dzC;
    protected FrsStarRankAndTaskContainer dzD;
    private int dzE = 3;

    public void ayM() {
        this.dzB = (TextView) this.dQn.findViewById(e.g.top_item_type);
        this.dzB.setText(TbadkCoreApplication.getInst().getString(e.j.game));
        this.dQr = new AdapterLinearLayout(this.dtN.getPageContext().getPageActivity());
        this.dQr.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dQr.setOrientation(1);
        this.dQr.setPadding(0, 0, 0, l.h(this.mContext.getPageActivity(), e.C0141e.tbds16));
        this.dzA = new f(this.dtN);
        this.dzA.b(this.dRd);
        this.dQr.setAdapter(this.dzA);
    }

    public void a(n nVar) {
        this.dtz = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bo(List<g> list) {
        if (this.dtN != null && this.dtN.awv() != null && this.dzA != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bxU = this.dtN.awv().bxU();
            if (!v.z(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bwB() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bxU != null) {
                for (int i2 = 0; i2 < v.y(bxU) && arrayList.size() < this.dzE; i2++) {
                    h hVar = (h) v.d(bxU, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).wg() == 1) {
                            this.dzE = 4;
                        } else if (this.dtN.awv().bbH() != null && this.dtN.awv().bbH().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dzA instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dzA;
                if (fVar.azt() != null && this.dtN.awv() != null) {
                    if (this.dtN.awv().gSN == 1) {
                        fVar.azt().dLH = true;
                    } else {
                        fVar.azt().dLH = false;
                    }
                    if (this.dtN.awv().bbH() != null) {
                        fVar.azt().dLJ = this.dtN.awv().bbH().getId();
                    }
                }
            }
            if (!v.z(list) && list.get(0).bwB() != 1) {
                arrayList.add(list.get(0));
            }
            this.dzA.c(this.dtz);
            this.dzA.setData(arrayList);
            this.dzA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayN() {
        if (this.dzA != null) {
            this.dzA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ayO() {
        if (this.dzA != null) {
            this.dzA.notifyDataSetChanged();
        }
    }
}
