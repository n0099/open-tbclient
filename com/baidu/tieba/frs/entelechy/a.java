package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n dkN;
    protected f dqk;
    protected TextView dql;
    protected ViewGroup dqm;
    protected FrsStarRankAndTaskContainer dqn;
    private int dqo = 3;

    public void avU() {
        this.dql = (TextView) this.dGs.findViewById(d.g.top_item_type);
        this.dql.setText(TbadkCoreApplication.getInst().getString(d.k.game));
        this.dGw = new AdapterLinearLayout(this.dla.getPageContext().getPageActivity());
        this.dGw.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dGw.setOrientation(1);
        this.dGw.setPadding(0, 0, 0, l.e(this.mContext.getPageActivity(), d.e.tbds16));
        this.dqk = new f(this.dla);
        this.dqk.a(this.dHi);
        this.dGw.setAdapter(this.dqk);
    }

    public void a(n nVar) {
        this.dkN = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bo(List<g> list) {
        if (this.dla != null && this.dla.atZ() != null && this.dqk != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bwJ = this.dla.atZ().bwJ();
            if (!w.A(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bvr() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bwJ != null) {
                for (int i2 = 0; i2 < w.z(bwJ) && arrayList.size() < this.dqo; i2++) {
                    h hVar = (h) w.d(bwJ, i2);
                    if (hVar instanceof bc) {
                        arrayList.add(hVar);
                        if (((bc) hVar).vq() == 1) {
                            this.dqo = 4;
                        } else if (this.dla.atZ().baT() != null && this.dla.atZ().baT().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dqk instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dqk;
                if (fVar.awC() != null && this.dla.atZ() != null) {
                    if (this.dla.atZ().gKm == 1) {
                        fVar.awC().dBR = true;
                    } else {
                        fVar.awC().dBR = false;
                    }
                    if (this.dla.atZ().baT() != null) {
                        fVar.awC().dBT = this.dla.atZ().baT().getId();
                    }
                }
            }
            if (!w.A(list) && list.get(0).bvr() != 1) {
                arrayList.add(list.get(0));
            }
            this.dqk.c(this.dkN);
            this.dqk.setData(arrayList);
            this.dqk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avV() {
        if (this.dqk != null) {
            this.dqk.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void avW() {
        if (this.dqk != null) {
            this.dqk.notifyDataSetChanged();
        }
    }
}
