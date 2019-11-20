package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private com.baidu.adp.base.e ceS;
    private BdTypeMultiColumnListView dHO;
    private e dHP;
    private h dHQ;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.ceS = eVar;
        this.dHO = bdTypeMultiColumnListView;
        sY();
    }

    private void sY() {
        this.dHP = new e((TbPageContext) this.ceS, com.baidu.tieba.ala.frsgamelive.b.c.dHY);
        this.dHQ = new h((TbPageContext) this.ceS, com.baidu.tieba.ala.frsgamelive.b.c.dHZ);
        this.agy.add(this.dHP);
        this.agy.add(this.dHQ);
        this.dHO.addAdapters(this.agy);
    }

    public void setDatas(List<m> list) {
        if (this.dHO != null) {
            this.dHO.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.dHP != null) {
            this.dHP.a(dVar);
        }
        if (this.dHQ != null) {
            this.dHQ.a(dVar);
        }
    }
}
