package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private com.baidu.adp.base.e dvg;
    private BdTypeListView eOj;
    private f fgG;
    private c fgH;
    private a fgI;
    private b fgJ;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dvg = eVar;
        this.eOj = bdTypeListView;
        jz(z);
    }

    private void jz(boolean z) {
        if (z) {
            this.fgH = new c((TbPageContext) this.dvg, com.baidu.tieba.ala.gamelist.b.a.eXy);
            this.aMj.add(this.fgH);
        } else {
            this.fgG = new f((TbPageContext) this.dvg, com.baidu.tieba.ala.gamelist.b.a.eXy);
            this.aMj.add(this.fgG);
        }
        this.fgI = new a((TbPageContext) this.dvg, com.baidu.tieba.ala.frsgamelive.b.a.fgL);
        this.fgJ = new b((TbPageContext) this.dvg, com.baidu.tieba.ala.frsgamelive.b.b.fgM);
        this.aMj.add(this.fgI);
        this.aMj.add(this.fgJ);
        this.eOj.addAdapters(this.aMj);
    }

    public void setDatas(List<m> list) {
        if (this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fgG != null) {
            this.fgG.a(dVar);
        }
        if (this.fgH != null) {
            this.fgH.a(dVar);
        }
    }
}
