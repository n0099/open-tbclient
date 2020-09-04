package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private com.baidu.adp.base.e efO;
    private BdTypeListView fCT;
    private f fXh;
    private c fXi;
    private a fXj;
    private b fXk;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.efO = eVar;
        this.fCT = bdTypeListView;
        lm(z);
    }

    private void lm(boolean z) {
        if (z) {
            this.fXi = new c((TbPageContext) this.efO, com.baidu.tieba.ala.gamelist.b.a.fMj);
            this.bbw.add(this.fXi);
        } else {
            this.fXh = new f((TbPageContext) this.efO, com.baidu.tieba.ala.gamelist.b.a.fMj);
            this.bbw.add(this.fXh);
        }
        this.fXj = new a((TbPageContext) this.efO, com.baidu.tieba.ala.frsgamelive.b.a.fXm);
        this.fXk = new b((TbPageContext) this.efO, com.baidu.tieba.ala.frsgamelive.b.b.fXn);
        this.bbw.add(this.fXj);
        this.bbw.add(this.fXk);
        this.fCT.addAdapters(this.bbw);
    }

    public void setDatas(List<q> list) {
        if (this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fXh != null) {
            this.fXh.a(eVar);
        }
        if (this.fXi != null) {
            this.fXi.a(eVar);
        }
    }
}
