package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> asP = new ArrayList();
    private BdTypeListView asR;
    private b fro;
    private c frp;
    private e frq;
    private f frr;
    private d frt;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.asR = bdTypeListView;
        wR();
    }

    private void wR() {
        this.fro = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.frw);
        this.frp = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.frz);
        this.frq = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.frB);
        this.frr = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.frC);
        this.frt = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.frA);
        this.asP.add(this.fro);
        this.asP.add(this.frp);
        this.asP.add(this.frq);
        this.asP.add(this.frr);
        this.asP.add(this.frt);
        this.asR.addAdapters(this.asP);
    }

    public void onDestroy() {
        if (this.fro != null) {
            this.fro.onDestroy();
        }
        if (this.frp != null) {
            this.frp.onDestroy();
        }
    }
}
