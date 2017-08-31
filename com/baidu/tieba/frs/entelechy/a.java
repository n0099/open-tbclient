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
    protected h cqg;
    protected f ctT;
    protected TextView ctU;
    protected ViewGroup ctV;
    protected ExpandLayout ctW;
    protected com.baidu.tieba.frs.view.a ctX;

    public void aip() {
        this.ctW = (ExpandLayout) this.cHl.findViewById(d.h.expandable_layout);
        this.ctU = (TextView) this.cHl.findViewById(d.h.top_item_type);
        this.ctU.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.ctT = new f(this.cqt);
        this.ctX = new com.baidu.tieba.frs.view.a(this.cqt, this.ctW, this.cHZ, this.ctT);
    }

    public void a(h hVar) {
        this.cqg = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiq() {
        if (this.cqt != null && this.cqt.ahf() != null && this.ctT != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> brt = this.cqt.ahf().brt();
            if (brt != null) {
                for (int i = 0; i < v.u(brt); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(brt, i);
                    if (fVar instanceof bj) {
                        arrayList.add((bj) fVar);
                    }
                }
            }
            if (this.ctT instanceof com.baidu.tieba.frs.f.c) {
                f fVar2 = this.ctT;
                if (com.baidu.tieba.frs.f.c.cEr != null && this.cqt.ahf() != null) {
                    if (this.cqt.ahf().gfK == 1) {
                        com.baidu.tieba.frs.f.c.cEr.cEh = true;
                    } else {
                        com.baidu.tieba.frs.f.c.cEr.cEh = false;
                    }
                    if (this.cqt.ahf().aOV() != null) {
                        com.baidu.tieba.frs.f.c.cEr.cEj = this.cqt.ahf().aOV().getId();
                    }
                }
            }
            this.ctX.b(this.cqg);
            this.ctX.aW(arrayList);
            this.ctX.alQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void air() {
        if (this.ctT != null) {
            this.ctT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ais() {
        if (this.ctT != null) {
            this.ctT.notifyDataSetChanged();
        }
    }
}
