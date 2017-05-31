package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.p;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected x bUZ;
    protected AdapterLinearLayout bXv;
    protected p bXw;
    protected TextView bXx;
    protected ViewGroup bXy;

    public void abj() {
        this.bXv = (AdapterLinearLayout) this.cis.findViewById(w.h.top_layout);
        this.bXx = (TextView) this.cis.findViewById(w.h.top_item_type);
        this.bXx.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.bXw = new p(this.aas.getPageActivity());
    }

    public void a(x xVar) {
        this.bUZ = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abk() {
        if (this.bVm != null && this.bVm.aau() != null && this.bXw != null) {
            ArrayList arrayList = new ArrayList();
            List<v> bhl = this.bVm.aau().bhl();
            if (bhl != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.q(bhl); i++) {
                    v vVar = (v) com.baidu.tbadk.core.util.x.c(bhl, i);
                    if (vVar instanceof bl) {
                        arrayList.add((bl) vVar);
                    }
                }
            }
            this.bXv.setAdapter(this.bXw);
            if (this.bXw instanceof com.baidu.tieba.frs.d.e) {
                p pVar = this.bXw;
                if (com.baidu.tieba.frs.d.e.cfm != null && this.bVm.aau() != null) {
                    if (this.bVm.aau().fzF == 1) {
                        com.baidu.tieba.frs.d.e.cfm.cfc = true;
                    } else {
                        com.baidu.tieba.frs.d.e.cfm.cfc = false;
                    }
                    if (this.bVm.aau().aIz() != null) {
                        com.baidu.tieba.frs.d.e.cfm.cfe = this.bVm.aau().aIz().getId();
                    }
                }
            }
            this.bXw.b(this.bUZ);
            this.bXw.setData(arrayList);
            this.bXw.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abl() {
        if (this.bXw != null) {
            this.bXw.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void abm() {
        if (this.bXw != null) {
            this.bXw.notifyDataSetChanged();
        }
    }
}
