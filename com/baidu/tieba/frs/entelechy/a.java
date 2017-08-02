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
    protected h ciT;
    protected f clt;
    protected TextView clu;
    protected ViewGroup clv;
    protected ExpandLayout clw;
    protected com.baidu.tieba.frs.view.a clx;

    public void agh() {
        this.clw = (ExpandLayout) this.cxD.findViewById(d.h.expandable_layout);
        this.clu = (TextView) this.cxD.findViewById(d.h.top_item_type);
        this.clu.setText(TbadkCoreApplication.getInst().getString(d.l.game));
        this.clt = new f(this.cjg);
        this.clx = new com.baidu.tieba.frs.view.a(this.cjg, this.clw, this.cyr, this.clt);
    }

    public void a(h hVar) {
        this.ciT = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agi() {
        if (this.cjg != null && this.cjg.afm() != null && this.clt != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.f> brw = this.cjg.afm().brw();
            if (brw != null) {
                for (int i = 0; i < u.u(brw); i++) {
                    com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(brw, i);
                    if (fVar instanceof bl) {
                        arrayList.add((bl) fVar);
                    }
                }
            }
            if (this.clt instanceof com.baidu.tieba.frs.f.c) {
                f fVar2 = this.clt;
                if (com.baidu.tieba.frs.f.c.cut != null && this.cjg.afm() != null) {
                    if (this.cjg.afm().gef == 1) {
                        com.baidu.tieba.frs.f.c.cut.cuj = true;
                    } else {
                        com.baidu.tieba.frs.f.c.cut.cuj = false;
                    }
                    if (this.cjg.afm().aOW() != null) {
                        com.baidu.tieba.frs.f.c.cut.cul = this.cjg.afm().aOW().getId();
                    }
                }
            }
            this.clx.b(this.ciT);
            this.clx.aP(arrayList);
            this.clx.ajv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agj() {
        if (this.clt != null) {
            this.clt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agk() {
        if (this.clt != null) {
            this.clt.notifyDataSetChanged();
        }
    }
}
