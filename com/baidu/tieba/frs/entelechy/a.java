package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.c {
    protected h cIp;
    protected g cMu;
    protected TextView cMv;
    protected ViewGroup cMw;
    protected ExpandLayout cMx;
    protected com.baidu.tieba.frs.view.a cMy;

    public void ane() {
        this.cMx = (ExpandLayout) this.dcF.findViewById(d.g.expandable_layout);
        this.cMv = (TextView) this.dcF.findViewById(d.g.top_item_type);
        this.cMv.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.cMu = new g(this.cIC);
        this.cMy = new com.baidu.tieba.frs.view.a(this.cIC, this.cMx, this.ddv, this.cMu);
    }

    public void a(h hVar) {
        this.cIp = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anf() {
        if (this.cIC != null && this.cIC.alE() != null && this.cMu != null) {
            ArrayList arrayList = new ArrayList();
            List<f> bwb = this.cIC.alE().bwb();
            if (bwb != null) {
                for (int i = 0; i < v.v(bwb); i++) {
                    f fVar = (f) v.c(bwb, i);
                    if (fVar instanceof bd) {
                        arrayList.add((bd) fVar);
                    }
                }
            }
            if (this.cMu instanceof com.baidu.tieba.frs.e.c) {
                g gVar = this.cMu;
                if (com.baidu.tieba.frs.e.c.cZc != null && this.cIC.alE() != null) {
                    if (this.cIC.alE().gzq == 1) {
                        com.baidu.tieba.frs.e.c.cZc.cYS = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cZc.cYS = false;
                    }
                    if (this.cIC.alE().aRo() != null) {
                        com.baidu.tieba.frs.e.c.cZc.cYU = this.cIC.alE().aRo().getId();
                    }
                }
            }
            this.cMy.c(this.cIp);
            this.cMy.bl(arrayList);
            this.cMy.ard();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ang() {
        if (this.cMu != null) {
            this.cMu.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anh() {
        if (this.cMu != null) {
            this.cMu.notifyDataSetChanged();
        }
    }
}
