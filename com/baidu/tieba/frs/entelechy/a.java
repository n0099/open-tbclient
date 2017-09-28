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
    protected h crv;
    protected f cvp;
    protected TextView cvq;
    protected ViewGroup cvr;
    protected ExpandLayout cvs;
    protected com.baidu.tieba.frs.view.a cvt;

    public void aiE() {
        this.cvs = (ExpandLayout) this.cIV.findViewById(d.h.expandable_layout);
        this.cvq = (TextView) this.cIV.findViewById(d.h.top_item_type);
        this.cvq.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cvp = new f(this.crI);
        this.cvt = new com.baidu.tieba.frs.view.a(this.crI, this.cvs, this.cJJ, this.cvp);
    }

    public void a(h hVar) {
        this.crv = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiF() {
        if (this.crI != null && this.crI.ahk() != null && this.cvp != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> bqC = this.crI.ahk().bqC();
            if (bqC != null) {
                for (int i = 0; i < v.t(bqC); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(bqC, i);
                    if (fVar instanceof bh) {
                        arrayList.add((bh) fVar);
                    }
                }
            }
            if (this.cvp instanceof com.baidu.tieba.frs.f.c) {
                f fVar2 = this.cvp;
                if (com.baidu.tieba.frs.f.c.cGc != null && this.crI.ahk() != null) {
                    if (this.crI.ahk().gel == 1) {
                        com.baidu.tieba.frs.f.c.cGc.cFS = true;
                    } else {
                        com.baidu.tieba.frs.f.c.cGc.cFS = false;
                    }
                    if (this.crI.ahk().aMZ() != null) {
                        com.baidu.tieba.frs.f.c.cGc.cFU = this.crI.ahk().aMZ().getId();
                    }
                }
            }
            this.cvt.b(this.crv);
            this.cvt.aW(arrayList);
            this.cvt.amf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiG() {
        if (this.cvp != null) {
            this.cvp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiH() {
        if (this.cvp != null) {
            this.cvp.notifyDataSetChanged();
        }
    }
}
