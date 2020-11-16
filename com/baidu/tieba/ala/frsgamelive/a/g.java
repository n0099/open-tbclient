package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private com.baidu.adp.base.e eGT;
    private f gCm;
    private c gCn;
    private a gCo;
    private b gCp;
    private BdTypeListView ghN;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eGT = eVar;
        this.ghN = bdTypeListView;
        mm(z);
    }

    private void mm(boolean z) {
        if (z) {
            this.gCn = new c((TbPageContext) this.eGT, com.baidu.tieba.ala.gamelist.b.a.grn);
            this.biN.add(this.gCn);
        } else {
            this.gCm = new f((TbPageContext) this.eGT, com.baidu.tieba.ala.gamelist.b.a.grn);
            this.biN.add(this.gCm);
        }
        this.gCo = new a((TbPageContext) this.eGT, com.baidu.tieba.ala.frsgamelive.b.a.gCr);
        this.gCp = new b((TbPageContext) this.eGT, com.baidu.tieba.ala.frsgamelive.b.b.gCs);
        this.biN.add(this.gCo);
        this.biN.add(this.gCp);
        this.ghN.addAdapters(this.biN);
    }

    public void setDatas(List<q> list) {
        if (this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gCm != null) {
            this.gCm.a(fVar);
        }
        if (this.gCn != null) {
            this.gCn.a(fVar);
        }
    }
}
