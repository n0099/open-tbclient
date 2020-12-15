package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> bnf = new ArrayList();
    private BdTypeListView bnh;
    private b hJA;
    private c hJB;
    private e hJC;
    private f hJD;
    private d hJE;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bnh = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.hJA = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hJH);
        this.hJB = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hJK);
        this.hJC = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hJM);
        this.hJD = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hJN);
        this.hJE = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hJL);
        this.bnf.add(this.hJA);
        this.bnf.add(this.hJB);
        this.bnf.add(this.hJC);
        this.bnf.add(this.hJD);
        this.bnf.add(this.hJE);
        this.bnh.addAdapters(this.bnf);
    }

    public void onDestroy() {
        if (this.hJA != null) {
            this.hJA.onDestroy();
        }
        if (this.hJB != null) {
            this.hJB.onDestroy();
        }
    }
}
