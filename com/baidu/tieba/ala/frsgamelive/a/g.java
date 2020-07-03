package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private com.baidu.adp.base.e dPR;
    private f fFK;
    private c fFL;
    private a fFM;
    private b fFN;
    private BdTypeListView fml;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dPR = eVar;
        this.fml = bdTypeListView;
        kg(z);
    }

    private void kg(boolean z) {
        if (z) {
            this.fFL = new c((TbPageContext) this.dPR, com.baidu.tieba.ala.gamelist.b.a.fvG);
            this.aUP.add(this.fFL);
        } else {
            this.fFK = new f((TbPageContext) this.dPR, com.baidu.tieba.ala.gamelist.b.a.fvG);
            this.aUP.add(this.fFK);
        }
        this.fFM = new a((TbPageContext) this.dPR, com.baidu.tieba.ala.frsgamelive.b.a.fFP);
        this.fFN = new b((TbPageContext) this.dPR, com.baidu.tieba.ala.frsgamelive.b.b.fFQ);
        this.aUP.add(this.fFM);
        this.aUP.add(this.fFN);
        this.fml.addAdapters(this.aUP);
    }

    public void setDatas(List<q> list) {
        if (this.fml != null) {
            this.fml.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fFK != null) {
            this.fFK.a(dVar);
        }
        if (this.fFL != null) {
            this.fFL.a(dVar);
        }
    }
}
