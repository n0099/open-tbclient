package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private com.baidu.adp.base.e dvc;
    private BdTypeListView eOe;
    private f fgB;
    private c fgC;
    private a fgD;
    private b fgE;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dvc = eVar;
        this.eOe = bdTypeListView;
        jz(z);
    }

    private void jz(boolean z) {
        if (z) {
            this.fgC = new c((TbPageContext) this.dvc, com.baidu.tieba.ala.gamelist.b.a.eXt);
            this.aMd.add(this.fgC);
        } else {
            this.fgB = new f((TbPageContext) this.dvc, com.baidu.tieba.ala.gamelist.b.a.eXt);
            this.aMd.add(this.fgB);
        }
        this.fgD = new a((TbPageContext) this.dvc, com.baidu.tieba.ala.frsgamelive.b.a.fgG);
        this.fgE = new b((TbPageContext) this.dvc, com.baidu.tieba.ala.frsgamelive.b.b.fgH);
        this.aMd.add(this.fgD);
        this.aMd.add(this.fgE);
        this.eOe.addAdapters(this.aMd);
    }

    public void setDatas(List<m> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fgB != null) {
            this.fgB.a(dVar);
        }
        if (this.fgC != null) {
            this.fgC.a(dVar);
        }
    }
}
