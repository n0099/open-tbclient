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
    protected f cDc;
    protected TextView cDd;
    protected ViewGroup cDe;
    protected ExpandLayout cDf;
    protected com.baidu.tieba.frs.view.a cDg;
    protected h cyX;

    public void akZ() {
        this.cDf = (ExpandLayout) this.cSp.findViewById(d.g.expandable_layout);
        this.cDd = (TextView) this.cSp.findViewById(d.g.top_item_type);
        this.cDd.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.cDc = new f(this.czk);
        this.cDg = new com.baidu.tieba.frs.view.a(this.czk, this.cDf, this.cTd, this.cDc);
    }

    public void a(h hVar) {
        this.cyX = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ala() {
        if (this.czk != null && this.czk.ajB() != null && this.cDc != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> btM = this.czk.ajB().btM();
            if (btM != null) {
                for (int i = 0; i < v.u(btM); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(btM, i);
                    if (fVar instanceof bh) {
                        arrayList.add((bh) fVar);
                    }
                }
            }
            if (this.cDc instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cDc;
                if (com.baidu.tieba.frs.e.c.cPx != null && this.czk.ajB() != null) {
                    if (this.czk.ajB().gnK == 1) {
                        com.baidu.tieba.frs.e.c.cPx.cPn = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cPx.cPn = false;
                    }
                    if (this.czk.ajB().aPU() != null) {
                        com.baidu.tieba.frs.e.c.cPx.cPp = this.czk.ajB().aPU().getId();
                    }
                }
            }
            this.cDg.c(this.cyX);
            this.cDg.aZ(arrayList);
            this.cDg.apa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alb() {
        if (this.cDc != null) {
            this.cDc.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void alc() {
        if (this.cDc != null) {
            this.cDc.notifyDataSetChanged();
        }
    }
}
