package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<AbsDelegateAdapter> boS = new ArrayList();
    private BdTypeListView boU;
    private f hXA;
    private d hXB;
    private b hXx;
    private c hXy;
    private e hXz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.boU = bdTypeListView;
        Kz();
    }

    private void Kz() {
        this.hXx = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hXE);
        this.hXy = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hXH);
        this.hXz = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hXJ);
        this.hXA = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hXK);
        this.hXB = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hXI);
        this.boS.add(this.hXx);
        this.boS.add(this.hXy);
        this.boS.add(this.hXz);
        this.boS.add(this.hXA);
        this.boS.add(this.hXB);
        this.boU.addAdapters(this.boS);
    }

    public void onDestroy() {
        if (this.hXx != null) {
            this.hXx.onDestroy();
        }
        if (this.hXy != null) {
            this.hXy.onDestroy();
        }
    }
}
