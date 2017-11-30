package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected h cIc;
    protected f cMf;
    protected TextView cMg;
    protected ViewGroup cMh;
    protected ExpandLayout cMi;
    protected com.baidu.tieba.frs.view.a cMj;

    public void amV() {
        this.cMi = (ExpandLayout) this.dbu.findViewById(d.g.expandable_layout);
        this.cMg = (TextView) this.dbu.findViewById(d.g.top_item_type);
        this.cMg.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.cMf = new f(this.cIp);
        this.cMj = new com.baidu.tieba.frs.view.a(this.cIp, this.cMi, this.dcj, this.cMf);
    }

    public void a(h hVar) {
        this.cIc = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amW() {
        if (this.cIp != null && this.cIp.alv() != null && this.cMf != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> bvu = this.cIp.alv().bvu();
            if (bvu != null) {
                for (int i = 0; i < v.v(bvu); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(bvu, i);
                    if (fVar instanceof bd) {
                        arrayList.add((bd) fVar);
                    }
                }
            }
            if (this.cMf instanceof com.baidu.tieba.frs.e.c) {
                f fVar2 = this.cMf;
                if (com.baidu.tieba.frs.e.c.cYM != null && this.cIp.alv() != null) {
                    if (this.cIp.alv().gwD == 1) {
                        com.baidu.tieba.frs.e.c.cYM.cYC = true;
                    } else {
                        com.baidu.tieba.frs.e.c.cYM.cYC = false;
                    }
                    if (this.cIp.alv().aRf() != null) {
                        com.baidu.tieba.frs.e.c.cYM.cYE = this.cIp.alv().aRf().getId();
                    }
                }
            }
            this.cMj.c(this.cIc);
            this.cMj.bl(arrayList);
            this.cMj.aqT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amX() {
        if (this.cMf != null) {
            this.cMf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void amY() {
        if (this.cMf != null) {
            this.cMf.notifyDataSetChanged();
        }
    }
}
