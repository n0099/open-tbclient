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
    protected n cZv;
    protected f ddM;
    protected TextView ddN;
    protected ViewGroup ddO;
    protected FrsStarRankAndTaskContainer ddP;

    public void arn() {
        this.ddN = (TextView) this.dtR.findViewById(d.g.top_item_type);
        this.ddN.setText(TbadkCoreApplication.getInst().getString(d.k.game));
        this.dtV = new AdapterLinearLayout(this.cZJ.getPageContext().getPageActivity());
        this.dtV.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dtV.setOrientation(1);
        this.dtV.setPadding(0, 0, 0, l.e(this.mContext.getPageActivity(), d.e.tbds16));
        this.ddM = new f(this.cZJ);
        this.ddM.a(this.duF);
        this.dtV.setAdapter(this.ddM);
    }

    public void a(n nVar) {
        this.cZv = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bi(List<g> list) {
        if (this.cZJ != null && this.cZJ.apD() != null && this.ddM != null) {
            ArrayList arrayList = new ArrayList();
            List<h> brg = this.cZJ.apD().brg();
            if (!v.w(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).bpQ() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (brg != null) {
                for (int i2 = 0; i2 < v.v(brg) && arrayList.size() < 2; i2++) {
                    h hVar = (h) v.c(brg, i2);
                    if (hVar instanceof bd) {
                        arrayList.add(hVar);
                    }
                }
            }
            if (this.ddM instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.ddM;
                if (com.baidu.tieba.frs.e.c.dpD != null && this.cZJ.apD() != null) {
                    if (this.cZJ.apD().guT == 1) {
                        com.baidu.tieba.frs.e.c.dpD.dpr = true;
                    } else {
                        com.baidu.tieba.frs.e.c.dpD.dpr = false;
                    }
                    if (this.cZJ.apD().aVq() != null) {
                        com.baidu.tieba.frs.e.c.dpD.dpt = this.cZJ.apD().aVq().getId();
                    }
                }
            }
            if (!v.w(list) && list.get(0).bpQ() != 1) {
                arrayList.add(list.get(0));
            }
            this.ddM.c(this.cZv);
            this.ddM.setData(arrayList);
            this.ddM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aro() {
        if (this.ddM != null) {
            this.ddM.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arp() {
        if (this.ddM != null) {
            this.ddM.notifyDataSetChanged();
        }
    }
}
