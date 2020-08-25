package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private com.baidu.adp.base.e efK;
    private BdTypeListView fCP;
    private f fXd;
    private c fXe;
    private a fXf;
    private b fXg;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.efK = eVar;
        this.fCP = bdTypeListView;
        lk(z);
    }

    private void lk(boolean z) {
        if (z) {
            this.fXe = new c((TbPageContext) this.efK, com.baidu.tieba.ala.gamelist.b.a.fMf);
            this.bbu.add(this.fXe);
        } else {
            this.fXd = new f((TbPageContext) this.efK, com.baidu.tieba.ala.gamelist.b.a.fMf);
            this.bbu.add(this.fXd);
        }
        this.fXf = new a((TbPageContext) this.efK, com.baidu.tieba.ala.frsgamelive.b.a.fXi);
        this.fXg = new b((TbPageContext) this.efK, com.baidu.tieba.ala.frsgamelive.b.b.fXj);
        this.bbu.add(this.fXf);
        this.bbu.add(this.fXg);
        this.fCP.addAdapters(this.bbu);
    }

    public void setDatas(List<q> list) {
        if (this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fXd != null) {
            this.fXd.a(eVar);
        }
        if (this.fXe != null) {
            this.fXe.a(eVar);
        }
    }
}
