package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private com.baidu.adp.base.e dWk;
    private f fLf;
    private c fLg;
    private a fLh;
    private b fLi;
    private BdTypeListView frv;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dWk = eVar;
        this.frv = bdTypeListView;
        kK(z);
    }

    private void kK(boolean z) {
        if (z) {
            this.fLg = new c((TbPageContext) this.dWk, com.baidu.tieba.ala.gamelist.b.a.fAN);
            this.aWf.add(this.fLg);
        } else {
            this.fLf = new f((TbPageContext) this.dWk, com.baidu.tieba.ala.gamelist.b.a.fAN);
            this.aWf.add(this.fLf);
        }
        this.fLh = new a((TbPageContext) this.dWk, com.baidu.tieba.ala.frsgamelive.b.a.fLk);
        this.fLi = new b((TbPageContext) this.dWk, com.baidu.tieba.ala.frsgamelive.b.b.fLl);
        this.aWf.add(this.fLh);
        this.aWf.add(this.fLi);
        this.frv.addAdapters(this.aWf);
    }

    public void setDatas(List<q> list) {
        if (this.frv != null) {
            this.frv.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fLf != null) {
            this.fLf.a(eVar);
        }
        if (this.fLg != null) {
            this.fLg.a(eVar);
        }
    }
}
