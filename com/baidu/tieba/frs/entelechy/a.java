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
    protected f cCJ;
    protected TextView cCK;
    protected ViewGroup cCL;
    protected ExpandLayout cCM;
    protected com.baidu.tieba.frs.view.a cCN;
    protected h cyE;

    public void akL() {
        this.cCM = (ExpandLayout) this.cRV.findViewById(d.g.expandable_layout);
        this.cCK = (TextView) this.cRV.findViewById(d.g.top_item_type);
        this.cCK.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.cCJ = new f(this.cyR);
        this.cCN = new com.baidu.tieba.frs.view.a(this.cyR, this.cCM, this.cSJ, this.cCJ);
    }

    public void a(h hVar) {
        this.cyE = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akM() {
        if (this.cyR != null && this.cyR.ajn() != null && this.cCJ != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> btA = this.cyR.ajn().btA();
            if (btA != null) {
                for (int i = 0; i < v.u(btA); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(btA, i);
                    if (fVar instanceof bh) {
                        arrayList.add((bh) fVar);
                    }
                }
            }
            if (this.cCJ instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cCJ;
                if (com.baidu.tieba.frs.e.c.cPd != null && this.cyR.ajn() != null) {
                    if (this.cyR.ajn().gmI == 1) {
                        com.baidu.tieba.frs.e.c.cPd.cOT = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cPd.cOT = false;
                    }
                    if (this.cyR.ajn().aPM() != null) {
                        com.baidu.tieba.frs.e.c.cPd.cOV = this.cyR.ajn().aPM().getId();
                    }
                }
            }
            this.cCN.c(this.cyE);
            this.cCN.aZ(arrayList);
            this.cCN.aoL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akN() {
        if (this.cCJ != null) {
            this.cCJ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void akO() {
        if (this.cCJ != null) {
            this.cCJ.notifyDataSetChanged();
        }
    }
}
