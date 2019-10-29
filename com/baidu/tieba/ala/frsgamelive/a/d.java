package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private com.baidu.adp.base.e cfJ;
    private BdTypeMultiColumnListView dIF;
    private e dIG;
    private h dIH;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cfJ = eVar;
        this.dIF = bdTypeMultiColumnListView;
        sX();
    }

    private void sX() {
        this.dIG = new e((TbPageContext) this.cfJ, com.baidu.tieba.ala.frsgamelive.b.c.dIP);
        this.dIH = new h((TbPageContext) this.cfJ, com.baidu.tieba.ala.frsgamelive.b.c.dIQ);
        this.agQ.add(this.dIG);
        this.agQ.add(this.dIH);
        this.dIF.addAdapters(this.agQ);
    }

    public void setDatas(List<m> list) {
        if (this.dIF != null) {
            this.dIF.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.dIG != null) {
            this.dIG.a(dVar);
        }
        if (this.dIH != null) {
            this.dIH.a(dVar);
        }
    }
}
