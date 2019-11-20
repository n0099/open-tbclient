package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private com.baidu.adp.base.e ceS;
    private f dHR;
    private c dHS;
    private a dHT;
    private b dHU;
    private BdTypeListView duK;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.ceS = eVar;
        this.duK = bdTypeListView;
        gY(z);
    }

    private void gY(boolean z) {
        if (z) {
            this.dHS = new c((TbPageContext) this.ceS, com.baidu.tieba.ala.gamelist.b.a.dCR);
            this.agy.add(this.dHS);
        } else {
            this.dHR = new f((TbPageContext) this.ceS, com.baidu.tieba.ala.gamelist.b.a.dCR);
            this.agy.add(this.dHR);
        }
        this.dHT = new a((TbPageContext) this.ceS, com.baidu.tieba.ala.frsgamelive.b.a.dHW);
        this.dHU = new b((TbPageContext) this.ceS, com.baidu.tieba.ala.frsgamelive.b.b.dHX);
        this.agy.add(this.dHT);
        this.agy.add(this.dHU);
        this.duK.addAdapters(this.agy);
    }

    public void setDatas(List<m> list) {
        if (this.duK != null) {
            this.duK.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.dHR != null) {
            this.dHR.a(dVar);
        }
        if (this.dHS != null) {
            this.dHS.a(dVar);
        }
    }
}
