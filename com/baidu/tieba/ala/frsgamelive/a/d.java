package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private com.baidu.adp.base.f eXW;
    private BdTypeMultiColumnListView gWU;
    private e gWV;
    private h gWW;

    public d(com.baidu.adp.base.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eXW = fVar;
        this.gWU = bdTypeMultiColumnListView;
        MT();
    }

    private void MT() {
        this.gWV = new e((TbPageContext) this.eXW, com.baidu.tieba.ala.frsgamelive.b.c.gXe);
        this.gWW = new h((TbPageContext) this.eXW, com.baidu.tieba.ala.frsgamelive.b.c.gXf);
        this.boM.add(this.gWV);
        this.boM.add(this.gWW);
        this.gWU.addAdapters(this.boM);
    }

    public void setDatas(List<n> list) {
        if (this.gWU != null) {
            this.gWU.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.g gVar) {
        if (this.gWV != null) {
            this.gWV.a(gVar);
        }
        if (this.gWW != null) {
            this.gWW.a(gVar);
        }
    }
}
