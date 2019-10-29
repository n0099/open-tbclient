package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private com.baidu.adp.base.e cfJ;
    private f dII;
    private c dIJ;
    private a dIK;
    private b dIL;
    private BdTypeListView dvB;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cfJ = eVar;
        this.dvB = bdTypeListView;
        gY(z);
    }

    private void gY(boolean z) {
        if (z) {
            this.dIJ = new c((TbPageContext) this.cfJ, com.baidu.tieba.ala.gamelist.b.a.dDI);
            this.agQ.add(this.dIJ);
        } else {
            this.dII = new f((TbPageContext) this.cfJ, com.baidu.tieba.ala.gamelist.b.a.dDI);
            this.agQ.add(this.dII);
        }
        this.dIK = new a((TbPageContext) this.cfJ, com.baidu.tieba.ala.frsgamelive.b.a.dIN);
        this.dIL = new b((TbPageContext) this.cfJ, com.baidu.tieba.ala.frsgamelive.b.b.dIO);
        this.agQ.add(this.dIK);
        this.agQ.add(this.dIL);
        this.dvB.addAdapters(this.agQ);
    }

    public void setDatas(List<m> list) {
        if (this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.dII != null) {
            this.dII.a(dVar);
        }
        if (this.dIJ != null) {
            this.dIJ.a(dVar);
        }
    }
}
