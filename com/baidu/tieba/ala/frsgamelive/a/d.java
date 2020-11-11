package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private com.baidu.adp.base.e eIz;
    private BdTypeMultiColumnListView gCC;
    private e gCD;
    private h gCE;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eIz = eVar;
        this.gCC = bdTypeMultiColumnListView;
        LY();
    }

    private void LY() {
        this.gCD = new e((TbPageContext) this.eIz, com.baidu.tieba.ala.frsgamelive.b.c.gCM);
        this.gCE = new h((TbPageContext) this.eIz, com.baidu.tieba.ala.frsgamelive.b.c.gCN);
        this.bky.add(this.gCD);
        this.bky.add(this.gCE);
        this.gCC.addAdapters(this.bky);
    }

    public void setDatas(List<q> list) {
        if (this.gCC != null) {
            this.gCC.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gCD != null) {
            this.gCD.a(fVar);
        }
        if (this.gCE != null) {
            this.gCE.a(fVar);
        }
    }
}
