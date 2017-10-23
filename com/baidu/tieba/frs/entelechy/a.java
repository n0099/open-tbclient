package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected h crj;
    protected f cvd;
    protected TextView cve;
    protected ViewGroup cvf;
    protected ExpandLayout cvg;
    protected com.baidu.tieba.frs.view.a cvh;

    public void aiz() {
        this.cvg = (ExpandLayout) this.cIJ.findViewById(d.h.expandable_layout);
        this.cve = (TextView) this.cIJ.findViewById(d.h.top_item_type);
        this.cve.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cvd = new f(this.crw);
        this.cvh = new com.baidu.tieba.frs.view.a(this.crw, this.cvg, this.cJx, this.cvd);
    }

    public void a(h hVar) {
        this.crj = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiA() {
        if (this.crw != null && this.crw.ahf() != null && this.cvd != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> bqu = this.crw.ahf().bqu();
            if (bqu != null) {
                for (int i = 0; i < v.t(bqu); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(bqu, i);
                    if (fVar instanceof bh) {
                        arrayList.add((bh) fVar);
                    }
                }
            }
            if (this.cvd instanceof com.baidu.tieba.frs.f.c) {
                f fVar2 = this.cvd;
                if (com.baidu.tieba.frs.f.c.cFQ != null && this.crw.ahf() != null) {
                    if (this.crw.ahf().gdW == 1) {
                        com.baidu.tieba.frs.f.c.cFQ.cFG = true;
                    } else {
                        com.baidu.tieba.frs.f.c.cFQ.cFG = false;
                    }
                    if (this.crw.ahf().aMU() != null) {
                        com.baidu.tieba.frs.f.c.cFQ.cFI = this.crw.ahf().aMU().getId();
                    }
                }
            }
            this.cvh.b(this.crj);
            this.cvh.aW(arrayList);
            this.cvh.ama();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiB() {
        if (this.cvd != null) {
            this.cvd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiC() {
        if (this.cvd != null) {
            this.cvd.notifyDataSetChanged();
        }
    }
}
