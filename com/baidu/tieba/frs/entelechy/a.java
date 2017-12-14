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
    protected h cIl;
    protected g cMq;
    protected TextView cMr;
    protected ViewGroup cMs;
    protected ExpandLayout cMt;
    protected com.baidu.tieba.frs.view.a cMu;

    public void ane() {
        this.cMt = (ExpandLayout) this.dcB.findViewById(d.g.expandable_layout);
        this.cMr = (TextView) this.dcB.findViewById(d.g.top_item_type);
        this.cMr.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.cMq = new g(this.cIy);
        this.cMu = new com.baidu.tieba.frs.view.a(this.cIy, this.cMt, this.ddq, this.cMq);
    }

    public void a(h hVar) {
        this.cIl = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anf() {
        if (this.cIy != null && this.cIy.alF() != null && this.cMq != null) {
            ArrayList arrayList = new ArrayList();
            List<f> bwb = this.cIy.alF().bwb();
            if (bwb != null) {
                for (int i = 0; i < v.v(bwb); i++) {
                    f fVar = (f) v.c(bwb, i);
                    if (fVar instanceof bd) {
                        arrayList.add((bd) fVar);
                    }
                }
            }
            if (this.cMq instanceof com.baidu.tieba.frs.e.c) {
                g gVar = this.cMq;
                if (com.baidu.tieba.frs.e.c.cYY != null && this.cIy.alF() != null) {
                    if (this.cIy.alF().gzl == 1) {
                        com.baidu.tieba.frs.e.c.cYY.cYO = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cYY.cYO = false;
                    }
                    if (this.cIy.alF().aRo() != null) {
                        com.baidu.tieba.frs.e.c.cYY.cYQ = this.cIy.alF().aRo().getId();
                    }
                }
            }
            this.cMu.c(this.cIl);
            this.cMu.bl(arrayList);
            this.cMu.ard();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ang() {
        if (this.cMq != null) {
            this.cMq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anh() {
        if (this.cMq != null) {
            this.cMq.notifyDataSetChanged();
        }
    }
}
