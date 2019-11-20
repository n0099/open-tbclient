package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView agA;
    private List<AbsDelegateAdapter> agy = new ArrayList();
    private b etr;
    private c ets;
    private e ett;
    private f etu;
    private d etv;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.agA = bdTypeListView;
        sY();
    }

    private void sY() {
        this.etr = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.ety);
        this.ets = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.etB);
        this.ett = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.etD);
        this.etu = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.etE);
        this.etv = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.etC);
        this.agy.add(this.etr);
        this.agy.add(this.ets);
        this.agy.add(this.ett);
        this.agy.add(this.etu);
        this.agy.add(this.etv);
        this.agA.addAdapters(this.agy);
    }

    public void onDestroy() {
        if (this.etr != null) {
            this.etr.onDestroy();
        }
        if (this.ets != null) {
            this.ets.onDestroy();
        }
    }
}
