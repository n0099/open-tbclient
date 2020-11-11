package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private com.baidu.adp.base.e eIz;
    private f gCF;
    private c gCG;
    private a gCH;
    private b gCI;
    private BdTypeListView gih;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eIz = eVar;
        this.gih = bdTypeListView;
        ml(z);
    }

    private void ml(boolean z) {
        if (z) {
            this.gCG = new c((TbPageContext) this.eIz, com.baidu.tieba.ala.gamelist.b.a.grG);
            this.bky.add(this.gCG);
        } else {
            this.gCF = new f((TbPageContext) this.eIz, com.baidu.tieba.ala.gamelist.b.a.grG);
            this.bky.add(this.gCF);
        }
        this.gCH = new a((TbPageContext) this.eIz, com.baidu.tieba.ala.frsgamelive.b.a.gCK);
        this.gCI = new b((TbPageContext) this.eIz, com.baidu.tieba.ala.frsgamelive.b.b.gCL);
        this.bky.add(this.gCH);
        this.bky.add(this.gCI);
        this.gih.addAdapters(this.bky);
    }

    public void setDatas(List<q> list) {
        if (this.gih != null) {
            this.gih.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gCF != null) {
            this.gCF.a(fVar);
        }
        if (this.gCG != null) {
            this.gCG.a(fVar);
        }
    }
}
