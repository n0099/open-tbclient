package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private com.baidu.adp.base.f eXa;
    private BdTypeMultiColumnListView gWV;
    private e gWW;
    private h gWX;

    public d(com.baidu.adp.base.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eXa = fVar;
        this.gWV = bdTypeMultiColumnListView;
        Kz();
    }

    private void Kz() {
        this.gWW = new e((TbPageContext) this.eXa, com.baidu.tieba.ala.frsgamelive.b.c.gXf);
        this.gWX = new h((TbPageContext) this.eXa, com.baidu.tieba.ala.frsgamelive.b.c.gXg);
        this.boS.add(this.gWW);
        this.boS.add(this.gWX);
        this.gWV.addAdapters(this.boS);
    }

    public void setDatas(List<n> list) {
        if (this.gWV != null) {
            this.gWV.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gWW != null) {
            this.gWW.a(hVar);
        }
        if (this.gWX != null) {
            this.gWX.a(hVar);
        }
    }
}
