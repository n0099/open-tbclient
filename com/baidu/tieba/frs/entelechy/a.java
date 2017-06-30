package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.k;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected x cdi;
    protected AdapterLinearLayout cfE;
    protected k cfF;
    protected TextView cfG;
    protected ViewGroup cfH;

    public void afa() {
        this.cfE = (AdapterLinearLayout) this.cqs.findViewById(w.h.top_layout);
        this.cfG = (TextView) this.cqs.findViewById(w.h.top_item_type);
        this.cfG.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.cfF = new k(this.aat.getPageActivity());
    }

    public void a(x xVar) {
        this.cdi = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afb() {
        if (this.cdv != null && this.cdv.aek() != null && this.cfF != null) {
            ArrayList arrayList = new ArrayList();
            List<v> blz = this.cdv.aek().blz();
            if (blz != null) {
                for (int i = 0; i < z.s(blz); i++) {
                    v vVar = (v) z.c(blz, i);
                    if (vVar instanceof bm) {
                        arrayList.add((bm) vVar);
                    }
                }
            }
            this.cfE.setAdapter(this.cfF);
            if (this.cfF instanceof com.baidu.tieba.frs.d.e) {
                k kVar = this.cfF;
                if (com.baidu.tieba.frs.d.e.cnC != null && this.cdv.aek() != null) {
                    if (this.cdv.aek().fJJ == 1) {
                        com.baidu.tieba.frs.d.e.cnC.cnr = true;
                    } else {
                        com.baidu.tieba.frs.d.e.cnC.cnr = false;
                    }
                    if (this.cdv.aek().aMt() != null) {
                        com.baidu.tieba.frs.d.e.cnC.cnu = this.cdv.aek().aMt().getId();
                    }
                }
            }
            this.cfF.b(this.cdi);
            this.cfF.setData(arrayList);
            this.cfF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afc() {
        if (this.cfF != null) {
            this.cfF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void afd() {
        if (this.cfF != null) {
            this.cfF.notifyDataSetChanged();
        }
    }
}
