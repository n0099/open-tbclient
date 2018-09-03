package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n dnB;
    protected f dsU;
    protected TextView dsV;
    protected ViewGroup dsW;
    protected FrsStarRankAndTaskContainer dsX;
    private int dsY = 3;

    public void awy() {
        this.dsV = (TextView) this.dJd.findViewById(f.g.top_item_type);
        this.dsV.setText(TbadkCoreApplication.getInst().getString(f.j.game));
        this.dJh = new AdapterLinearLayout(this.dnP.getPageContext().getPageActivity());
        this.dJh.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dJh.setOrientation(1);
        this.dJh.setPadding(0, 0, 0, l.f(this.mContext.getPageActivity(), f.e.tbds16));
        this.dsU = new com.baidu.tieba.frs.view.f(this.dnP);
        this.dsU.a(this.dJT);
        this.dJh.setAdapter(this.dsU);
    }

    public void a(n nVar) {
        this.dnB = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(List<g> list) {
        if (this.dnP != null && this.dnP.auC() != null && this.dsU != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bvo = this.dnP.auC().bvo();
            if (!w.z(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).btV() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bvo != null) {
                for (int i2 = 0; i2 < w.y(bvo) && arrayList.size() < this.dsY; i2++) {
                    h hVar = (h) w.d(bvo, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).vd() == 1) {
                            this.dsY = 4;
                        } else if (this.dnP.auC().aZg() != null && this.dnP.auC().aZg().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dsU instanceof com.baidu.tieba.frs.e.c) {
                com.baidu.tieba.frs.view.f fVar = this.dsU;
                if (fVar.axg() != null && this.dnP.auC() != null) {
                    if (this.dnP.auC().gLl == 1) {
                        fVar.axg().dEA = true;
                    } else {
                        fVar.axg().dEA = false;
                    }
                    if (this.dnP.auC().aZg() != null) {
                        fVar.axg().dEC = this.dnP.auC().aZg().getId();
                    }
                }
            }
            if (!w.z(list) && list.get(0).btV() != 1) {
                arrayList.add(list.get(0));
            }
            this.dsU.c(this.dnB);
            this.dsU.setData(arrayList);
            this.dsU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awz() {
        if (this.dsU != null) {
            this.dsU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awA() {
        if (this.dsU != null) {
            this.dsU.notifyDataSetChanged();
        }
    }
}
