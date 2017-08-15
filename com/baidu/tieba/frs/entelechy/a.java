package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected h ckM;
    protected f cnn;
    protected TextView cno;
    protected ViewGroup cnp;
    protected ExpandLayout cnq;
    protected com.baidu.tieba.frs.view.a cnr;

    public void agJ() {
        this.cnq = (ExpandLayout) this.cAV.findViewById(d.h.expandable_layout);
        this.cno = (TextView) this.cAV.findViewById(d.h.top_item_type);
        this.cno.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.cnn = new f(this.ckZ);
        this.cnr = new com.baidu.tieba.frs.view.a(this.ckZ, this.cnq, this.cBJ, this.cnn);
    }

    public void a(h hVar) {
        this.ckM = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agK() {
        if (this.ckZ != null && this.ckZ.afN() != null && this.cnn != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> bsl = this.ckZ.afN().bsl();
            if (bsl != null) {
                for (int i = 0; i < u.u(bsl); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(bsl, i);
                    if (fVar instanceof bl) {
                        arrayList.add((bl) fVar);
                    }
                }
            }
            if (this.cnn instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cnn;
                if (com.baidu.tieba.frs.e.c.cxO != null && this.ckZ.afN() != null) {
                    if (this.ckZ.afN().ghi == 1) {
                        com.baidu.tieba.frs.e.c.cxO.cxE = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cxO.cxE = false;
                    }
                    if (this.ckZ.afN().aPO() != null) {
                        com.baidu.tieba.frs.e.c.cxO.cxG = this.ckZ.afN().aPO().getId();
                    }
                }
            }
            this.cnr.b(this.ckM);
            this.cnr.aS(arrayList);
            this.cnr.ako();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agL() {
        if (this.cnn != null) {
            this.cnn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agM() {
        if (this.cnn != null) {
            this.cnn.notifyDataSetChanged();
        }
    }
}
