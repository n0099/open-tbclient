package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected h cqY;
    protected f cuL;
    protected TextView cuM;
    protected ViewGroup cuN;
    protected ExpandLayout cuO;
    protected com.baidu.tieba.frs.view.a cuP;

    public void aiA() {
        this.cuO = (ExpandLayout) this.cIf.findViewById(d.h.expandable_layout);
        this.cuM = (TextView) this.cIf.findViewById(d.h.top_item_type);
        this.cuM.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cuL = new f(this.crm);
        this.cuP = new com.baidu.tieba.frs.view.a(this.crm, this.cuO, this.cIT, this.cuL);
    }

    public void a(h hVar) {
        this.cqY = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiB() {
        if (this.crm != null && this.crm.ahq() != null && this.cuL != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> brE = this.crm.ahq().brE();
            if (brE != null) {
                for (int i = 0; i < v.u(brE); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(brE, i);
                    if (fVar instanceof bj) {
                        arrayList.add((bj) fVar);
                    }
                }
            }
            if (this.cuL instanceof com.baidu.tieba.frs.f.c) {
                f fVar2 = this.cuL;
                if (com.baidu.tieba.frs.f.c.cFj != null && this.crm.ahq() != null) {
                    if (this.crm.ahq().ggE == 1) {
                        com.baidu.tieba.frs.f.c.cFj.cEZ = true;
                    } else {
                        com.baidu.tieba.frs.f.c.cFj.cEZ = false;
                    }
                    if (this.crm.ahq().aPg() != null) {
                        com.baidu.tieba.frs.f.c.cFj.cFb = this.crm.ahq().aPg().getId();
                    }
                }
            }
            this.cuP.b(this.cqY);
            this.cuP.aW(arrayList);
            this.cuP.amb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiC() {
        if (this.cuL != null) {
            this.cuL.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiD() {
        if (this.cuL != null) {
            this.cuL.notifyDataSetChanged();
        }
    }
}
